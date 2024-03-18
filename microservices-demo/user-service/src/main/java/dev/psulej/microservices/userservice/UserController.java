package dev.psulej.microservices.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Map<Long, User> database = Map.of(
            1L, new User(1, "johndoe@wp.pl", "John", "Doe"),
            2L, new User(2, "annasmith@wp.pl", "Anna", "Smith")
    );

    @GetMapping("/{id}")
    User getUser(@PathVariable long id) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return database.get(id);
    }
}
