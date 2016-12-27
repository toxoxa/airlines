package sample;

import entity.Flight;
import entity.Request;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import org.hibernate.Session;
import utils.AirlineService;
import utils.HibernateUtil;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    /** Контрол списка рейсов */
    @FXML
    private ListView<Flight> flightsLW;

    /** Список рейсов */
    private ObservableList<Flight> flights;

    /** Список рейсов с фильтрацией */
    private FilteredList<Flight> flightsFiltered;

    /** Контрол списка заявок */
    @FXML
    private ListView<Request> requestsLW;

    /** Список заявок */
    private ObservableList<Request> requests;

    /** Список заявок с фильтрацией */
    private FilteredList<Request> requestsFiltered;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        flights = FXCollections.observableList(AirlineService.getAirlineDAO().listFlights());
        flightsFiltered = new FilteredList<>(flights, s -> true);
        flightsLW.setItems(flightsFiltered);

        requests = FXCollections.observableList(AirlineService.getAirlineDAO().listRequests());
        requestsFiltered = new FilteredList<>(requests, s -> true);
        requestsLW.setItems(requestsFiltered);
    }

    /** Событие добавления рейса */
    @FXML
    public void onAddFlight() {
        Optional<Flight> result = getAddFlightDialog().showAndWait();

        if (result.isPresent()) {
            AirlineService.getAirlineDAO().createFlight(result.get());
            flights.add(result.get());
        }
    }

    /** Событие добавления заявки */
    @FXML
    public void onAddRequest() {
        Optional<Request> result = getAddRequestDialog().showAndWait();

        if (result.isPresent()) {
            AirlineService.getAirlineDAO().createRequest(result.get());
            requests.add(result.get());
        }
    }

    /** Событие удаления рейса */
    @FXML
    public void onDeleteFlight() {
        int id = flightsLW.getSelectionModel().getSelectedItem().getId();
        int idx = flightsLW.getSelectionModel().getSelectedIndex();
        AirlineService.getAirlineDAO().deleteFlight(id);
        flights.remove(idx);
    }

    /** Событие удаления заявки */
    @FXML
    public void onDeleteRequest() {
        int id = requestsLW.getSelectionModel().getSelectedItem().getId();
        int idx = requestsLW.getSelectionModel().getSelectedIndex();
        AirlineService.getAirlineDAO().deleteRequest(id);
        requests.remove(idx);
    }

    /** Дилог добавления рейса */
    private Dialog<Flight> getAddFlightDialog() {
        Dialog<Flight> dialog = new Dialog<>();
        dialog.setTitle("Добавление");
        dialog.setHeaderText("Введите значения полей");
        dialog.setResizable(true);

        Label label1 = new Label("Номер: ");
        Label label2 = new Label("Пункт отправления: ");
        Label label3 = new Label("Пункт назначения: ");
        Label label4 = new Label("Дата и время вылета: ");
        Label label5 = new Label("Тип самолета: ");
        Label label6 = new Label("Стоимость билета($): ");
        TextField text1 = new TextField();
        TextField text2 = new TextField();
        TextField text3 = new TextField();
        TextField text4 = new TextField();
        TextField text5 = new TextField();
        TextField text6 = new TextField();

        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(text1, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(text2, 2, 2);
        grid.add(label3, 1, 3);
        grid.add(text3, 2, 3);
        grid.add(label4, 1, 4);
        grid.add(text4, 2, 4);
        grid.add(label5, 1, 5);
        grid.add(text5, 2, 5);
        grid.add(label6, 1, 6);
        grid.add(text6, 2, 6);
        dialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        final Button okButton = (Button) dialog.getDialogPane().lookupButton(buttonTypeOk);
        okButton.addEventFilter(ActionEvent.ACTION, ae -> {
            Boolean valid = true;

            setNormalStyle(text1);
            setNormalStyle(text2);
            setNormalStyle(text3);
            setNormalStyle(text4);
            setNormalStyle(text5);
            setNormalStyle(text6);

            if (!text1.getText().matches("\\d+$")) {
                setInvalidStyle(text1);
                valid = false;
            }

            if (!text2.getText().matches("\\D+$")) {
                setInvalidStyle(text2);
                valid = false;
            }

            if (!text3.getText().matches("\\D+$")) {
                setInvalidStyle(text3);
                valid = false;
            }

            if (!text5.getText().matches("\\D+$")) {
                setInvalidStyle(text5);
                valid = false;
            }

            if (!text6.getText().matches("\\d+$")) {
                setInvalidStyle(text6);
                valid = false;
            }

            if (!valid) {
                ae.consume();
            }
        });

        dialog.setResultConverter(b -> {
            if (b == buttonTypeOk) {
                return new Flight(Integer.parseInt(text1.getText()), text2.getText(), text3.getText(), text4.getText(), text5.getText(), Integer.parseInt(text6.getText()));
            }

            return null;
        });

        return dialog;
    }

    /** Дилог добавления рейса */
    private Dialog<Request> getAddRequestDialog() {
        Dialog<Request> dialog = new Dialog<>();
        dialog.setTitle("Добавление");
        dialog.setHeaderText("Введите значения полей");
        dialog.setResizable(true);

        Label label1 = new Label("Пункт отправления: ");
        Label label2 = new Label("Пункт назначения: ");
        Label label3 = new Label("Дата и время вылета: ");
        Label label4 = new Label("Имя пассажира: ");
        Label label5 = new Label("Фамилия пассажира: ");
        TextField text1 = new TextField();
        TextField text2 = new TextField();
        TextField text3 = new TextField();
        TextField text4 = new TextField();
        TextField text5 = new TextField();

        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(text1, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(text2, 2, 2);
        grid.add(label3, 1, 3);
        grid.add(text3, 2, 3);
        grid.add(label4, 1, 4);
        grid.add(text4, 2, 4);
        grid.add(label5, 1, 5);
        grid.add(text5, 2, 5);
        dialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        final Button okButton = (Button) dialog.getDialogPane().lookupButton(buttonTypeOk);
        okButton.addEventFilter(ActionEvent.ACTION, ae -> {
            Boolean valid = true;

            setNormalStyle(text1);
            setNormalStyle(text2);
            setNormalStyle(text3);
            setNormalStyle(text4);
            setNormalStyle(text5);

            if (text1.getText().matches("\\D+$")) {
                setInvalidStyle(text1);
                valid = false;
            }

            if (!text2.getText().matches("\\D+$")) {
                setInvalidStyle(text2);
                valid = false;
            }

            if (!text4.getText().matches("\\D+$")) {
                setInvalidStyle(text4);
                valid = false;
            }

            if (!text5.getText().matches("\\D+$")) {
                setInvalidStyle(text5);
                valid = false;
            }

            if (!valid) {
                ae.consume();
            }
        });

        dialog.setResultConverter(b -> {
            if (b == buttonTypeOk) {
                return new Request(text1.getText(), text2.getText(), text3.getText(), text4.getText(), text5.getText());
            }

            return null;
        });

        return dialog;
    }

    /** Валидный стиль поля ввода */
    private void setInvalidStyle(TextField field) {
        field.setStyle("-fx-text-box-border: red");
    }

    /** Обычный стиль поля ввода */
    private void setNormalStyle(TextField field) {
        field.setStyle("-fx-text-box-border: transparent");
    }
}
