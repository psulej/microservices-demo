package psulej.microservices.carservice.user;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


public class UserServiceBasedUserProvider implements UserProvider {

    private final WebClient webClient;

    public UserServiceBasedUserProvider(WebClient.Builder webClientBuilder, UserServiceProperties userServiceProperties) {
        HttpClient client = HttpClient.create()
                .responseTimeout(userServiceProperties.timeout());
        this.webClient = webClientBuilder.baseUrl(userServiceProperties.url())
                .clientConnector(new ReactorClientHttpConnector(client))
                .build();
    }

    @Override
    public User getUser(long userId) {
        return webClient.get()
                .uri("/users/{userId}", userId)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }
}
