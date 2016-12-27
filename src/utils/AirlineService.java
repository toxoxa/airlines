package utils;

import dao.AirlineDAO;

/**
 * Created by Антон on 27.12.2016.
 */
public class AirlineService {
    private static AirlineDAO airlineDAO = null;

    /**
     * Получение DAO рейсов/заявок
     * @return DAO для работы с рейсами/заявками
     */
    public static AirlineDAO getAirlineDAO() {
        if (airlineDAO == null)
            airlineDAO = new AirlineDAO();

        return airlineDAO;
    }
}
