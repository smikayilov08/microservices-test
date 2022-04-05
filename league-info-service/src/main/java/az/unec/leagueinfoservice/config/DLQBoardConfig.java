package az.unec.leagueinfoservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DLQBoardConfig {

    public static final String DEAD_LETTER_BOARD_QUEUE_NAME="dead_board_queue_name";
    public static final String DEAD_LETTER_BOARD_ROUTING_KEY="dead_board_routingKey";

    @Bean
    public Queue dlqueueBoard(){
        return QueueBuilder.durable(DEAD_LETTER_BOARD_QUEUE_NAME).build();
    }

    @Bean
    public Binding bindingDLQBoard(DirectExchange exchange){
        return BindingBuilder.bind(dlqueueBoard())
                .to(exchange)
                .with(DEAD_LETTER_BOARD_ROUTING_KEY);
    }
}
