package az.unec.leagueinfoservice.service.impl;

import az.unec.leagueinfoservice.client.dto.BoardDtoList;
import az.unec.leagueinfoservice.config.BoardMQConfig;
import az.unec.leagueinfoservice.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;


@Service
public class BoardService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitAdmin admin;

    public void sendClubNameToBoardQueue(String clubName){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, BoardMQConfig.BOARD_ROUTING_KEY,clubName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BoardDtoList getBoardFromLeagueBoardQueue(){
        BoardDtoList boardDtoList=rabbitTemplate.receiveAndConvert(BoardMQConfig.LEAGUE_BOARD_QUEUE_NAME,
                ParameterizedTypeReference.forType(BoardDtoList.class));
        if (boardDtoList==null){
            admin.purgeQueue(BoardMQConfig.BOARD_QUEUE_NAME);
        }
        return boardDtoList;
    }

}
