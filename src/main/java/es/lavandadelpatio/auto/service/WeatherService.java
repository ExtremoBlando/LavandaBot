package es.lavandadelpatio.auto.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by raulm on 22/07/2017.
 */
@Service
public class WeatherService {

    @Value("${openweather.apikey}")
    private String API_KEY;

    public WeatherDataResponse getWeatherForCity(String city){


        return null;
    }


    class WeatherDataResponse{

        Coordenadas coord;




        class Coordenadas{
            float lon, lat;
        }
    }
}
