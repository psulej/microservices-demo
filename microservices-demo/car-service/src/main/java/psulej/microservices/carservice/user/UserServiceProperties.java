package psulej.microservices.carservice.user;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "app.user-service")
public record UserServiceProperties (
        String url,
        Duration timeout
){
}
