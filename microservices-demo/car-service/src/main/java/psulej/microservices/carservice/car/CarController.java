package psulej.microservices.carservice.car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    Car getCar(@PathVariable long id) {
        return carService.getCar(id);
    }

    @GetMapping("/car-with-user/{id}")
    CarWithUserDto getCarWithUserById(@PathVariable long id) {
        return carService.getCarWithUserById(id);
    }
}