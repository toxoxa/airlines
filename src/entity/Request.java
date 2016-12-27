package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Антон on 27.12.2016.
 */
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private int id;

    @Column()
    private String departure;

    @Column()
    private String destination;

    @Column()
    private String departureDate;

    @Column()
    private String name;

    @Column()
    private String surname;

    public Request() {
    }

    public Request(String departure, String destination, String departureDate, String name, String surname) {
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return (this.getName() + " " + this.getSurname() + ", " + this.getDeparture() + " - " + this.getDestination() + ", " + this.getDepartureDate());
    }
}
