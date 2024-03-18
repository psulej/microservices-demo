package psulej.microservices.carservice.user;

public interface UserProvider {
    User getUser(long userId);
}