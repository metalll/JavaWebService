package Publisher;

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
        Endpoint.publish("http://192.168.1.3:1999/wss/hello", new WebServiceImpl());
        System.out.println("Publisher: Сервер поднять! Порт 1999");

    }
}
