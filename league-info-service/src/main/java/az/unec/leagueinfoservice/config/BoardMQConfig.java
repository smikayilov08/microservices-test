package az.unec.leagueinfoservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardMQConfig {

    public static final String BOARD_QUEUE_NAME="board_queue_name";
    public static final String BOARD_ROUTING_KEY="board_routingKey";



    public static final String LEAGUE_BOARD_QUEUE_NAME="league_board_name";
    public static final String LEAGUE_BOARD_ROUTING_KEY="league_board_routingKey";

    @Bean
    public Queue queueBoard(){
        return QueueBuilder.durable(BOARD_QUEUE_NAME)
                .withArgument("x-dead-letter-exchange",RabbitMQConfig.EXCHANGE_NAME)
                .withArgument("x-dead-letter-routing-key", DLQBoardConfig.DEAD_LETTER_BOARD_ROUTING_KEY)
                .build();
    }


    @Bean
    public Binding bindingBoard(DirectExchange exchange){
        return BindingBuilder.bind(queueBoard())
                .to(exchange)
                .with(BOARD_ROUTING_KEY);
    }

    @Bean
    public Queue queueLeagueBoard(){
        return new Queue(LEAGUE_BOARD_QUEUE_NAME);
    }

    @Bean
    public  Binding bindingLeageuBoard(DirectExchange exchange){
        return BindingBuilder.bind(queueLeagueBoard())
                .to(exchange)
                .with(LEAGUE_BOARD_ROUTING_KEY);
    }
}
