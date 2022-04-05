package az.unec.clubinfoservice.service;

import az.unec.clubinfoservice.config.LeagueClubMQConfig;
import az.unec.clubinfoservice.config.RabbitMqConfig;
import az.unec.clubinfoservice.model.AllClubsDTO;
import az.unec.clubinfoservice.model.ClubsDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeagueService {

    @Autowired
    private ClubService clubService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = LeagueClubMQConfig.CLUB_QUEUE_NAME_2)
    public void getClubNameAndSendClubManager(String clubName) {
        ClubsDTO clubs = clubService.club(clubName);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, LeagueClubMQConfig.LEAGUE_CLUB_ROUTRING_KEY,clubs);

    }

    @RabbitListener(queues =LeagueClubMQConfig.ALL_CLUB_QUEUE_NAME)
    public void sendAllClubToAllLeagueClubQueue(String message){
        AllClubsDTO allClubsDTO=clubService.allClub();
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME,LeagueClubMQConfig.ALL_LEAGUE_CLUB_ROUTING_KEY,allClubsDTO);
    }
}
