package az.unec.leagueinfoservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DLQClubConfig {

    public static final String DEAD_CLUB_QUEUE_NAME="dead_club_queue";
    public static final String DEAD_CLUB_ROUTING_KEY="dead_club_routingKey";

    @Bean
    public Queue dlqClubQueue(){
        return QueueBuilder.durable(DEAD_CLUB_QUEUE_NAME).build();
    }

    @Bean
    public Binding dlqClubBinding(DirectExchange exchange){
        return BindingBuilder.bind(dlqClubQueue())
                .to(exchange)
                .with(DEAD_CLUB_ROUTING_KEY);
    }
}
