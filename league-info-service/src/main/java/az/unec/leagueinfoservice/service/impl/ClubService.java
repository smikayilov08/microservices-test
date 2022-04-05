package az.unec.leagueinfoservice.service.impl;

import az.unec.leagueinfoservice.client.model.ClubManager;
import az.unec.leagueinfoservice.config.ClubMQConfig;
import az.unec.leagueinfoservice.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;


@Service
public class ClubService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitAdmin admin;

    public void setClubQueue(String clubName) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, ClubMQConfig.CLUB_ROUTING_KEY_2, clubName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ClubManager getClubAndManagerFromClubQueue() {
        ClubManager clubManager = rabbitTemplate.receiveAndConvert(ClubMQConfig.LEAGUE_CLUB_QUEUE_NAME,
                ParameterizedTypeReference.forType(ClubManager.class));
        if (clubManager == null) {
            admin.purgeQueue(ClubMQConfig.CLUB_QUEUE_NAME_2);
        }
        return clubManager;
    }

}
