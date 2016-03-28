package Data;

import Model.Weather;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lexa on 28.03.16.
 */


public class DataManager {
    public static DataManager instance = null;
    private final String url = "jdbc:sqlite:/home/lexa/IdeaProjects/JavaServer/out/production/JavaServer/Data/main.sqlite";
    private ConnectionSource source;
    private Dao<Weather, String> dao;

    private DataManager() {

        try {


            source = new JdbcConnectionSource(url);
            dao = DaoManager.createDao(source, Weather.class);

        } catch (Exception e) {

            System.err.println("Ошибка подключения к бд:" + e);

        }

    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public Dao<Weather, String> getDao() {
        return dao;
    }

    public List<Weather> getAllWeather() {

        System.out.print("Запрос к бд...");
        try {
            source = new JdbcConnectionSource(url);
            dao = DaoManager.createDao(source, Weather.class);
            System.out.print("Запрос выполнен успешно");
            return dao.queryForAll();

        } catch (Exception e) {

            System.err.println("Ошибка подключения к бд:" + e);
            return null;
        }

    }

    public Weather getWeatherForCity(String city) {
        for (Weather item : getAllWeather()) {
            if (city.equals(item.getCity())) {
                System.out.println("Найдена погода для города " + city);
                return item;
            }
        }
        System.err.println("Погоды для города " + city + " нет в наличии");
        return null;
    }

    public void addWeather(Weather weather) {
        try {
            dao.createOrUpdate(weather);

        } catch (SQLException e) {
            System.err.println("Ошибка подключения к бд:" + e);
        }

    }


}

