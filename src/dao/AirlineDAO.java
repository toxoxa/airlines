package dao;

import entity.Flight;
import entity.Request;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

/**
 * Created by Антон on 27.12.2016.
 */
public class AirlineDAO {
    /** Получение списка всех рейсов */
    public List<Flight> listFlights() {
        Session s = HibernateUtil.getSession();
        List<Flight> flights = s.createQuery("from Flight", Flight.class).list();
        s.close();
        return flights;
    }

    /** Получение списка всех заявок */
    public List<Request> listRequests() {
        Session s = HibernateUtil.getSession();
        List<Request> requests = s.createQuery("from Request", Request.class).list();
        s.close();
        return requests;
    }

    /** Создание рейса */
    public void createFlight(Flight flight) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.save(flight);
        s.getTransaction().commit();
        s.close();
    }

    /** Создание заявки */
    public void createRequest(Request request) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.save(request);
        s.getTransaction().commit();
        s.close();
    }

    /** Чтение рейса из базы */
    public Flight readFlight(int id) {
        Session s = HibernateUtil.getSession();
        Flight flight = s.get(Flight.class, id);
        s.close();
        return flight;
    }

    /** Чтение заявки из базы */
    public Request readRequest(int id) {
        Session s = HibernateUtil.getSession();
        Request request = s.get(Request.class, id);
        s.close();
        return request;
    }

    /** Удаление рейса */
    public void deleteFlight(int id) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        Flight flight = s.load(Flight.class, id);
        s.delete(flight);
        s.getTransaction().commit();
        s.close();
    }

    /** Удаление рейса */
    public void deleteRequest(int id) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        Request request = s.load(Request.class, id);
        s.delete(request);
        s.getTransaction().commit();
        s.close();
    }
}
