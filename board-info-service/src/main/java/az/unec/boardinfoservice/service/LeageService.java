package az.unec.boardinfoservice.service;

import az.unec.boardinfoservice.config.LeagueBoardMQConfig;
import az.unec.boardinfoservice.config.RabbitMQConfig;
import az.unec.boardinfoservice.data.BoardDtoList;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ClubBoardService clubBoardService;

    @RabbitListener(queues = LeagueBoardMQConfig.BOARD_QUEUE_NAME)
    public void getClubNameAndSendBoardToLeagueQueue(String clubName){

        BoardDtoList boardDto=clubBoardService.getBoard(clubName);

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,LeagueBoardMQConfig.LEAGUE_BOARD_ROUTING_KEY,boardDto);
    }
}
