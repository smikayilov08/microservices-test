package az.unec.leagueinfoservice.service.impl;

import az.unec.leagueinfoservice.config.PopularTeamMQConfig;
import az.unec.leagueinfoservice.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopTeamService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendClubToTeamQueue(String clubName){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, PopularTeamMQConfig.TEAM_ROUTING_KEY,clubName);
    }
}
