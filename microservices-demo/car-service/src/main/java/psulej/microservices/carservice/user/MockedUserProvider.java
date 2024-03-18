package psulej.microservices.carservice.user;


public class MockedUserProvider implements UserProvider{

    @Override
    public User getUser(long userId) {
        return new User(1, "fakeuser@gmail.com", "Jake", "Fake");
    }
}
