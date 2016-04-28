package Controller.Implemention;

import Controller.Interfaces.IWebService;
import Data.DataManager;
import Model.Weather;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
// таже аннотация, что и при описании интерфейса,


@WebService(endpointInterface = "Controller.Interfaces.IWebService", targetNamespace = "WEB")
public class WebServiceImpl implements IWebService {


    @Override
    @WebMethod(action = "getWeather", operationName = "getWeather")
    public String[] getWeather(String city) {
        String str[] = new String[2];

        Weather weather = DataManager.getInstance().getWeatherForCity(city);
        str[0] = weather.getTemp();
        str[1] = weather.getTypeOfWeather();

        return str;
    }

    @Override
    @WebMethod(action = "getCites", operationName = "getCites")
    public String[] getCites() {

        List<String> list = new ArrayList<>();
        for (Weather item : DataManager.getInstance().getAllWeather()) {
            list.add(item.getCity());
        }
        return list.toArray(new String[list.size()]);

    }
}

