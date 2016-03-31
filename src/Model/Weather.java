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
    @DatabaseField
    private String cityToResponse;
    @DatabaseField
    private String countryToResponse;


    public Weather() {
    }

    private Weather(String city, String temp, String typeOfWeather, String cityToResponse, String countryToResponse) {
        if (city == null || temp == null || typeOfWeather == null | cityToResponse == null || countryToResponse == null)
            throw new NullPointerException();
        this.city = city;
        this.temp = temp;
        this.typeOfWeather = typeOfWeather;
        this.cityToResponse = cityToResponse;
        this.countryToResponse = countryToResponse;
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

    public String getCountryToResponse() {
        return countryToResponse;
    }

    public void setCountryToResponse(String countryToResponse) {
        this.countryToResponse = countryToResponse;
    }

    public String getCityToResponse() {
        return cityToResponse;
    }

    public void setCityToResponse(String cityToResponse) {
        this.cityToResponse = cityToResponse;
    }


    public static class Builder {
        private String city;
        private String temp;
        private String typeOfWeather;
        private String cityToResponse;
        private String countryToResponse;

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

        public Builder withCityToResponce(String city) {
            this.cityToResponse = city;
            return this;
        }

        public Builder withCountryToResponce(String countryToResponce) {
            this.countryToResponse = countryToResponce;
            return this;
        }

        public Weather build() {

            return new Weather(city, temp, typeOfWeather, cityToResponse, countryToResponse);
        }
    }
}
