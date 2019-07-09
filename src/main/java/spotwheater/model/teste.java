package spotwheater.model;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Locale;

public class teste {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        final String uri = "https://api.openweathermap.org/data/2.5/weather?q=araraquara,BR&APPID=4b08e7a8d3ed6417d6e057a0c4687d99";

        SpotWheater spotWheater = restTemplate.getForObject(uri, SpotWheater.class);
        //log.info(String.valueOf(spotWheater));
        System.out.println(spotWheater);
    }
}
