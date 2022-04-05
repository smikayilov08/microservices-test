package az.unec.leagueinfoservice.service;

import az.unec.leagueinfoservice.client.model.data.ClubData;
import az.unec.leagueinfoservice.config.ClubMQConfig;
import az.unec.leagueinfoservice.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class AllClubService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    public void setAllClubQueue(){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, ClubMQConfig.ALL_CLUB_ROUTING_KEY,"calling all clubs");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ClubData getAllClubfromAllClubQueue(){
        ClubData clubData=rabbitTemplate.receiveAndConvert(ClubMQConfig.ALL_LEAGUE_CLUB_QUEUE_NAME,
                ParameterizedTypeReference.forType(ClubData.class));
        if (clubData==null){
            rabbitAdmin.purgeQueue(ClubMQConfig.ALL_CLUB_QUEUE_NAME);
        }
        return clubData;
    }


}
