package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Антон on 27.12.2016.
 */
@Entity
public class Request {
    /** Поле первичного ключа*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private int id;

    /** Пункт отправления */
    @Column()
    private String departure;

    /** Пункт назначения*/
    @Column()
    private String destination;

    /** Дата и время отправления*/
    @Column()
    private String departureDate;

    /** Имя пассажира */
    @Column()
    private String name;

    /** Фамилия пассажира */
    @Column()
    private String surname;

    /** Конструктор */
    public Request() {
    }

    /** Конструктор */
    public Request(String departure, String destination, String departureDate, String name, String surname) {
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.name = name;
        this.surname = surname;
    }

    /** Возвращает Id*/
    public int getId() {
        return id;
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

    /** Возвращает Имя пассажира*/
    public String getName() {
        return name;
    }

    /** Возвращает Фамилию пассажира*/
    public String getSurname() {
        return surname;
    }

    /** Возвращает строку с информацией о заявке*/
    @Override
    public String toString() {
        return (this.getName() + " " + this.getSurname() + ", " + this.getDeparture() + " - " + this.getDestination() + ", " + this.getDepartureDate());
    }
}
