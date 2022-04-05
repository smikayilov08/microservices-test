package az.unec.leagueinfoservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClubMQConfig {

    public static final String CLUB_QUEUE_NAME_2="club_queue";
    public static final String CLUB_ROUTING_KEY_2="club_routingKey";

    public static final String LEAGUE_CLUB_QUEUE_NAME="league_club_queue";
    public static final String LEAGUE_CLUB_ROUTRING_KEY="league_club_routingKey";

    public static final String ALL_LEAGUE_CLUB_QUEUE_NAME="all_league_club_queue";
    public static final String ALL_LEAGUE_CLUB_ROUTING_KEY="all_league_club_routingKey";

    public static final String ALL_CLUB_QUEUE_NAME="all_club_queue";
    public static final String ALL_CLUB_ROUTING_KEY="all_club_routingKey";

    @Bean
    public Queue queueAllClub(){return new Queue(ALL_CLUB_QUEUE_NAME);}

    @Bean
    public Binding bindingAllClub(DirectExchange exchange){
        return BindingBuilder.bind(queueAllClub()).
                to(exchange).
                with(ALL_CLUB_ROUTING_KEY);
    }

    @Bean
    public Queue queueAllLeagueClub(){return new Queue(ALL_LEAGUE_CLUB_QUEUE_NAME);}

    @Bean
    public Binding bindingAllLeagueClub(DirectExchange exchange){
        return BindingBuilder.bind(queueAllLeagueClub()).
                to(exchange).
                with(ALL_LEAGUE_CLUB_ROUTING_KEY);
    }
    @Bean
    public Queue queueClub(){
        return QueueBuilder.durable(CLUB_QUEUE_NAME_2)
                .withArgument("x-dead-letter-exchange",RabbitMQConfig.EXCHANGE_NAME)
                .withArgument("x-dead-letter-routing-key",DLQClubConfig.DEAD_CLUB_ROUTING_KEY)
                .build();
    }

    @Bean
    public Binding bindingClub(DirectExchange exchange){
        return BindingBuilder.bind(queueClub())
                .to(exchange)
                .with(CLUB_ROUTING_KEY_2);
    }

    @Bean
    public Queue queueLeagueClub(){
        return new Queue(LEAGUE_CLUB_QUEUE_NAME);
    }

    @Bean
    public Binding bindgingLeagueClub(DirectExchange exchange){
        return BindingBuilder.bind(queueLeagueClub())
                .to(exchange)
                .with(LEAGUE_CLUB_ROUTRING_KEY);
    }
}
