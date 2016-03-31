package Publisher;

import Controller.DBUpdater.WeatherControllerLookup;
import Controller.Implemention.WebServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by lexa on 21.03.16.
 */
public class WebPublisher {
    public static void main(String... args) {
        // запускаем веб-сервер на порту 1986
        // и по адресу, указанному в первом аргументе,
        // запускаем веб-сервис, передаваемый во втором аргументе
        Endpoint.publish("http://localhost:1999/WeatherService", new WebServiceImpl());
        System.out.println("Publisher: Сервер поднят! Порт 1999");


        new WeatherControllerLookup().start();

    }
}
