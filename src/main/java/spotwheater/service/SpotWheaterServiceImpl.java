package spotwheater.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import spotwheater.exception.NotFoundException;
import spotwheater.model.SpotWheater;
import spotwheater.util.ConsumeServices;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SpotWheaterServiceImpl implements SpotWheaterService {

    @Autowired
    private MessageSource messageSource;

    private static final Logger log = LoggerFactory.getLogger(SpotWheaterServiceImpl.class);

    private final double  formuleValue = 273.15;

    ConsumeServices consumeServices = new ConsumeServices();

    @Override
    public SpotWheater findOne(String city, String country) throws NotFoundException {

        try {
            Map<String, String> vars = getParameterUriCall(city,country);

            RestTemplate restTemplate = new RestTemplate();
            SpotWheater spotWheater = restTemplate.getForObject(consumeServices.URI, SpotWheater.class,vars);
            log.info(String.valueOf(spotWheater));

            changeTemperatureResult(spotWheater);

            return spotWheater;

        }catch (Exception e){
               throw  new NotFoundException(messageSource.getMessage("cityNotFound",null,null));
        }



    }

    private Map<String,String> getParameterUriCall(String city, String country) {

        Map<String, String> vars = new HashMap<>();
        vars.put("city",city+","+getCountryCode(country));
        vars.put("token",consumeServices.TOKEN);

        return vars;
    }

    private String getCountryCode(String country) {
        String codSearch=null;
        String[] countries = Locale.getISOCountries();
        for (String singleCountry: countries) {
            Locale locale = new Locale("",singleCountry);
            String code = locale.getDisplayName();
            if(code.equalsIgnoreCase(country)){
                codSearch=singleCountry.toString();
            }
        }
        return codSearch;
    }

    private void changeTemperatureResult(SpotWheater spotWheater) {

        double valueInCelsius = (spotWheater.getMain().getTemp() - formuleValue);
        spotWheater.getMain().setTemp( Math.floor(valueInCelsius));
    }
}
