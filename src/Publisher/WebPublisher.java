package Publisher;

import Controller.DBUpdater.WeatherControllerLookup;
import Controller.Implemention.WebServiceImpl;

import javax.xml.ws.Endpoint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lexa on 21.03.16.
 */
public class WebPublisher {
    public static void main(String... args) {

        String address = null;
        // запускаем веб-сервер по
        // адресу, указанному в первом аргументе,
        // запускаем веб-сервис, передаваемый во втором аргументе
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Добро пожаловать в сервис, который парсит другой сервис");
        System.out.println("Введите URL сервиса. Например: http://localhost:6682//weatherService");

        try {
            address = reader.readLine();
        } catch (IOException e) {
            System.err.println("Введите адрес правильно пожалуйста");
            System.exit(-1);
        }

        try {


            Endpoint.publish(address, new WebServiceImpl());

        } catch (Exception e) {

            System.err.println("Сервер не поднялся и сказал:" + e);
            System.err.println("Попробуйте еще раз...");
            System.exit(-1);

        }
        System.out.println("Publisher: Сервер поднят! WSDL описание сервера " + address + "?wsdl");

        new WeatherControllerLookup().start();

        WebServiceImpl impl = new WebServiceImpl();
        for (Object item : impl.getCites()) {
            System.out.println(item + "Объекты");
        }

    }
}
