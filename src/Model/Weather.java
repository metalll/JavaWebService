package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by lexa on 28.03.16.
 */

@DatabaseTable
public class Weather {

    @DatabaseField(id = true)
    private String city;
    @DatabaseField
    private String temp;
    @DatabaseField
    private String typeOfWeather;

    public Weather() {
    }

    private Weather(String city, String temp, String typeOfWeather) {
        this.city = city;
        this.temp = temp;
        this.typeOfWeather = typeOfWeather;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTypeOfWeather() {
        return typeOfWeather;
    }

    public void setTypeOfWeather(String typeOfWeather) {
        this.typeOfWeather = typeOfWeather;
    }


    public static class Builder {
        private String city;
        private String temp;
        private String typeOfWeather;

        public Builder() {
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withTemp(String temp) {
            this.temp = temp;
            return this;
        }

        public Builder withTypeOfWeather(String typeOfWeather) {
            this.typeOfWeather = typeOfWeather;
            return this;


        }

        public Weather build() {
            Weather weather = new Weather(city, temp, typeOfWeather);

            return weather;
        }

    }
}
