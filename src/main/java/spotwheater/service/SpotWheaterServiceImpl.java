package spotwheater.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import spotwheater.exception.NotFoundException;
import spotwheater.model.SpotWheater;
import spotwheater.util.ConsumeServices;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SpotWheaterServiceImpl implements SpotWheaterService {

    @Autowired
    private MessageSource messageSource;

    private static final Logger log = LoggerFactory.getLogger(SpotWheaterServiceImpl.class);

    private final double  formuleValue = 273.15;

    @Override
    public SpotWheater findOne(String city, String country) throws NotFoundException {

        ConsumeServices consumeServices = new ConsumeServices();

        Map<String, String> vars = new HashMap<>();
        vars.put("city",city.replace(" ","+")+",BR");
        vars.put("token",consumeServices.TOKEN);

        RestTemplate restTemplate = new RestTemplate();
        SpotWheater spotWheater = restTemplate.getForObject(consumeServices.URI, SpotWheater.class,vars);
     //   SpotWheater spotWheater = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=araraquara,BR&APPID=4b08e7a8d3ed6417d6e057a0c4687d99", SpotWheater.class);
        log.info(String.valueOf(spotWheater));

        if (spotWheater == null){
            throw new NotFoundException(messageSource.getMessage("cityNotFound",null,null));
        }

        changeTemperatureResult(spotWheater);

        return spotWheater;
    }

    private void changeTemperatureResult(SpotWheater spotWheater) {

        double valueInCelsius = (spotWheater.getMain().getTemp() - formuleValue);
        spotWheater.getMain().setTemp( Math.floor(valueInCelsius));
    }
}
