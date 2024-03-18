package psulej.microservices.carservice.user;

public record User (
        long id,
        String email,
        String firstName,
        String lastName
) {
    public User(long id, String email, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}