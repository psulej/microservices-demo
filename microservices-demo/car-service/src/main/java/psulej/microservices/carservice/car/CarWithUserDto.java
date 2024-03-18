package psulej.microservices.carservice.car;

import psulej.microservices.carservice.user.User;

public record CarWithUserDto(
        Car car,
        User user
) {
}
