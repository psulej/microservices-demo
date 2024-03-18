package psulej.microservices.carservice.car;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import psulej.microservices.carservice.user.User;
import psulej.microservices.carservice.user.UserProvider;

import java.util.Map;

@Service
public class CarService {

   private final UserProvider userProvider;

    public CarService(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    private final Map<Long, Car> database = Map.of(
            1L, new Car(1, 1, "Audi", "A4", 265),
            2L, new Car(2, 2, "Volkswagen", "Passat", 140)
    );


    Car getCar(long id) {
        return database.get(id);
    }

    CarWithUserDto getCarWithUserById(@PathVariable long id) {
        Car car = database.get(id);
        User user = userProvider.getUser(car.userId());
        return new CarWithUserDto(car, user);
    }
}
