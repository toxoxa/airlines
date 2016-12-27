package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Антон on 27.12.2016.
 */
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private int id;

    @Column()
    private int number;

    @Column()
    private String departure;

    @Column()
    private String destination;

    @Column()
    private String departureDate;

    @Column()
    private String planeType;

    @Column()
    private int cost;


    public Flight() {
    }

    public Flight(int number, String departure, String destination, String departureDate, String planeType, int cost) {
        this.number = number;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.planeType = planeType;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
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

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return ("№" + this.getNumber() + ": " + this.getDeparture() + " - " + this.getDestination() + ", " + this.getDepartureDate() + ", цена: " + this.getCost() + "$");
    }
}
