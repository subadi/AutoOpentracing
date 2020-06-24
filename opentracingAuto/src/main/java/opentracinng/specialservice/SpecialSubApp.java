package opentracinng.specialservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan("model.user")
@SpringBootApplication
public class SpecialSubApp {

    public static void main(String[] args) {
        System.setProperty("server.port", "8092");
        SpringApplication.run(SpecialSubApp.class, args);
    }
}
