package az.unec.clubinfoservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DLQManagerConfig {

    public static final String DEAD_MANAGER_QUEUE_NAME="dead_manager_queue";
    public  static final String DEAD_MANAGER_ROUNTING_KEY="dead_manager_routingKey";

    @Bean
    public Queue dlQueue(){
        return QueueBuilder.durable(DEAD_MANAGER_QUEUE_NAME).build();
    }

    @Bean
    public Binding dlqManagerBinding(DirectExchange exchange){
        return BindingBuilder.bind(dlQueue())
                .to(exchange)
                .with(DEAD_MANAGER_ROUNTING_KEY);
    }
}
