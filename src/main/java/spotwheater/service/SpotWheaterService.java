package spotwheater.service;

import spotwheater.exception.NotFoundException;
import spotwheater.model.SpotWheater;

public interface SpotWheaterService {

    SpotWheater findOne(String city, String country) throws NotFoundException;

}
