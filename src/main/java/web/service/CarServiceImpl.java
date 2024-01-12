package web.service;

import web.model.Car;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getCars(List<Car> cars, int count) {
        if (count >= 5) {
            return cars;
        }

        return cars.subList(0, count);
    }
}
