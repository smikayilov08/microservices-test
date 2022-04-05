package az.unec.leagueinfoservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PopularTeamMQConfig {

    public static final String TEAM_QUEUE_NAME="team_queue";
    public static final String TEAM_ROUTING_KEY="team_routingKey";

    @Bean
    public Queue queueTeam(){
        return new Queue(TEAM_QUEUE_NAME);
    }

    @Bean
    public Binding bindingTeam(DirectExchange exchange){
        return  BindingBuilder.bind(queueTeam())
                .to(exchange)
                .with(TEAM_ROUTING_KEY);
    }


}
