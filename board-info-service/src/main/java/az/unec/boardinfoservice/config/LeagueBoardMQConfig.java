package az.unec.boardinfoservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class LeagueBoardMQConfig {

    public static final String BOARD_QUEUE_NAME="board_queue_name";
    public static final String LEAGUE_BOARD_ROUTING_KEY="league_board_routingKey";

}
