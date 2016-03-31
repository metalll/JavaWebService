package Controller.DBUpdater;


import Data.DataManager;
import Model.Weather;
import Utils.DescriptionTranslator;
import Utils.KelvinToCelciusConverter;
import org.bitpipeline.lib.owm.OwmClient;
import org.bitpipeline.lib.owm.WeatherData;
import org.bitpipeline.lib.owm.WeatherStatusResponse;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by lexa on 29.03.16.
 */
public class WeatherControllerLookup extends Thread {


    private OwmClient client = null;
    private WeatherStatusResponse currentWeather = null;


    public WeatherControllerLookup() {

        /*    OwmClient owm = new OwmClient();
        WeatherStatusResponse currentWeather = null;
        try {
            currentWeather = owm.currentWeatherAtCity("Odessa", "UA");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        if (currentWeather.hasWeatherStatus()) {
                WeatherData weather = currentWeather.getWeatherStatus().get(0);
                if (weather.getPrecipitation() == Integer.MIN_VALUE) {
                    WeatherData.WeatherCondition weatherCondition = weather.getWeatherConditions().get(0);

                    String description = weatherCondition.getDescription();
                    System.out.println(description + "  "+ KelvinToCelciusConverter.Convert(weather.getTemp())+"°С");


            }

        }
*/
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Обновление бд...#Поток:" + this.getName());
            for (Weather item : DataManager.getInstance().getAllWeather()) {
                try {
                    client = new OwmClient();
                    currentWeather = client.currentWeatherAtCity(item.getCityToResponse(), item.getCountryToResponse());
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }


                if (currentWeather.hasWeatherStatus()) {
                    WeatherData weather = currentWeather.getWeatherStatus().get(0);
                    if (weather.getPrecipitation() == Integer.MIN_VALUE) {
                        WeatherData.WeatherCondition weatherCondition = weather.getWeatherConditions().get(0);

                        String description = weatherCondition.getDescription();


                        System.out.println("Ответ от сервера по городу " + item.getCity() + " " + DescriptionTranslator.Translate(description) + "  " + KelvinToCelciusConverter.Convert(weather.getTemp()) + "°С" + "...#Поток:" + this.getName());

                        item.setTemp(KelvinToCelciusConverter.Convert(weather.getTemp()) + "°С");
                        item.setTypeOfWeather(DescriptionTranslator.Translate(description));

                        DataManager.getInstance().addWeather(item);

                        System.out.println("Прогноз погоды для города " + item.getCity() + " успешно обновлен!...#Поток:" + this.getName());
                    }

                }

            }
            System.out.println("Обновление бд успешно завершено...#Поток:" + this.getName());
            try {
                sleep(300000);

            } catch (InterruptedException e) {
                System.out.println("Поток " + this.getName() + " по не понятным причинам упал с фразой: " + e + "Перезапуск потока...");
                this.stop();
                this.start();

            }
        }

    }
}
