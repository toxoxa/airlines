package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Антон on 27.12.2016.
 */
@Entity
public class Flight {
    /** Поле первичного ключа*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private int id;

    /** Номер самолета*/
    @Column()
    private int number;

    /** Пункт отправления*/
    @Column()
    private String departure;

    /** Пункт назначения*/
    @Column()
    private String destination;

    /** Дата и время отправления*/
    @Column()
    private String departureDate;

    /** Тип самолета*/
    @Column()
    private String planeType;

    /** Цена билета*/
    @Column()
    private int cost;

    /** Конструктор */
    public Flight() {
    }

    /** Конструктор */
    public Flight(int number, String departure, String destination, String departureDate, String planeType, int cost) {
        this.number = number;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.planeType = planeType;
        this.cost = cost;
    }

    /** Возвращает Id*/
    public int getId() {
        return id;
    }

    /** Возвращает Номер рейса*/
    public int getNumber() {
        return number;
    }

    /** Возвращает Пункт отправления*/
    public String getDeparture() {
        return departure;
    }

    /** Возвращает Пункт назначения*/
    public String getDestination() {
        return destination;
    }

    /** Возвращает Дату и время отправления*/
    public String getDepartureDate() {
        return departureDate;
    }

    /** Возвращает Цену билета*/
    public int getCost() {
        return cost;
    }

    /** Возвращает строку с информацией о рейсе */
    @Override
    public String toString() {
        return ("№" + this.getNumber() + ": " + this.getDeparture() + " - " + this.getDestination() + ", " + this.getDepartureDate() + ", цена: " + this.getCost() + "$");
    }
}
