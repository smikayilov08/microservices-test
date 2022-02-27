package az.unec.managerinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManagerInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerInfoServiceApplication.class, args);
    }

}
