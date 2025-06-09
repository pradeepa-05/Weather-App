// package com.example.weatherapp.service;
package com.example.demo;


import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getWeather(String city) {
        String url = apiUrl + city + "&appid=" + apiKey + "&units=metric";
        return restTemplate.getForObject(url, Map.class);
    }
}
