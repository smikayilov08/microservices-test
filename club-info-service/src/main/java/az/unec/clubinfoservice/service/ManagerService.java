package az.unec.clubinfoservice.service;

import az.unec.clubinfoservice.config.ManagerClubMQConfig;
import az.unec.clubinfoservice.config.RabbitMqConfig;
import az.unec.clubinfoservice.model.ManagerDTO;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    public ManagerDTO getManagerFromQueue() {
        ManagerDTO managerDTO=rabbitTemplate.receiveAndConvert( ManagerClubMQConfig.CLUB_QUEUE_NAME,
                ParameterizedTypeReference.forType(ManagerDTO.class));
        if(managerDTO==null){
            rabbitAdmin.purgeQueue(ManagerClubMQConfig.MANAGER_QUEUE_NAME);
        }
        return managerDTO;
    }

    public void setManagerQueue(String clubName){
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, ManagerClubMQConfig.MANAGER_ROUTING_KEY,clubName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
