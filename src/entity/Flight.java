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

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.getDestination();
    }
}
