package psulej.microservices.carservice.user;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UserConfiguration {

    @Configuration
    @EnableConfigurationProperties({UserServiceProperties.class})
    @ConditionalOnProperty(value = "app.user-service.enabled", havingValue = "true")
    static class UserServiceEnabledConfiguration {
        @Bean
        UserProvider userServiceBasedUserProvider(WebClient.Builder webClientBuilder, UserServiceProperties userServiceProperties) {
            return new UserServiceBasedUserProvider(webClientBuilder, userServiceProperties);
        }
    }
    @Configuration
    @ConditionalOnProperty(value = "app.user-service.enabled", havingValue = "false", matchIfMissing = true)
    static class UserServiceDisabledConfiguration {
        @Bean
        UserProvider mockedUserProvider() { return new MockedUserProvider(); }
    }
}
