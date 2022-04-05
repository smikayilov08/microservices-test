package az.unec.clubinfoservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagerClubMQConfig {

    public static final String MANAGER_QUEUE_NAME = "manager_queue";
    public static final String MANAGER_ROUTING_KEY = "manager_routingKey";

    public static final String CLUB_QUEUE_NAME = "liveScore_club_queue";
    public static final String CLUB_ROUTING_KEY = "liveScore_club_routingKey";

    @Bean
    public Queue queueManager() {
        return QueueBuilder.durable(MANAGER_QUEUE_NAME)
                .withArgument("x-dead-letter-exchange",RabbitMqConfig.EXCHANGE_NAME)
                .withArgument("x-dead-letter-routing-key",DLQManagerConfig.DEAD_MANAGER_ROUNTING_KEY)
                .build();
    }

    @Bean
    public Queue queueClub() {
        return new Queue(CLUB_QUEUE_NAME);
    }

    @Bean
    public Binding bindingManager(DirectExchange exchange) {
        return BindingBuilder.
                bind(queueManager()).
                to(exchange).
                with(MANAGER_ROUTING_KEY);
    }

    @Bean
    public Binding bindingClub(DirectExchange exchange) {
        return BindingBuilder.
                bind(queueClub()).
                to(exchange).
                with(CLUB_ROUTING_KEY);
    }
}
