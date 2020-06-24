package opentracinng.subscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan("model.user")
@SpringBootApplication
public class SubscriptionApp {


    public static void main(String[] args) {
        System.setProperty("server.port", "8091");
        SpringApplication.run(SubscriptionApp.class, args);
    }

}
