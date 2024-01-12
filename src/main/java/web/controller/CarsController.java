package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    public static List<Car> getCarsList() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, 1234, "Niva"));
        cars.add(new Car(2, 3214, "Solaris"));
        cars.add(new Car(3, 1235, "Vesta"));
        cars.add(new Car(4, 1237, "Camry"));
        cars.add(new Car(5, 1233, "Lancer"));
        cars.add(new Car(6, 1433, "Urus"));

        return cars;
    }

    @GetMapping("/cars")
    public String getCars(
            @RequestParam(value = "count", required = false) String count,
            ModelMap model
    ) {
        model.addAttribute("cars", getCarsList());
        return "cars";
    }


    @GetMapping(value = "/cars", params = {"count"})
    public String getCarsCount(@RequestParam(value = "count") int count,
                               ModelMap model) {
        List<Car> cars = getCarsList();
        CarService carServiceImpl = new CarServiceImpl();

        model.addAttribute(
                "cars",
                carServiceImpl.getCars(cars, count)
        );

        return "cars";
    }
}
