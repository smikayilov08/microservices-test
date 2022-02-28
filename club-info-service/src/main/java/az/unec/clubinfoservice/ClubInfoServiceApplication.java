package az.unec.clubinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ClubInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubInfoServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    @Primary
    public RestTemplate webCBuilder() {
        return new RestTemplate();
    }
}
