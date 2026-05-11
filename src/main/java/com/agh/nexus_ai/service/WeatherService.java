package com.agh.nexus_ai.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Tool(description = "Get current weather for a given city")
    public String getWeather(String city) {
        int temp ;
        if (city.equalsIgnoreCase("Pune")){
            temp =34;
        }else if (city.equalsIgnoreCase("Mumbai")){
            temp = 27;
        }else {
            temp = 39;
        }

        return city + " weather: " + temp +  ", Partly Cloudy";
    }

}
