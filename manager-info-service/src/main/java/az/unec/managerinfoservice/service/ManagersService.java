package az.unec.managerinfoservice.service;

import az.unec.managerinfoservice.config.RabbitMqConfig;
import az.unec.managerinfoservice.data.ManagersDTO;
import az.unec.managerinfoservice.data.MangersRepo;
import az.unec.managerinfoservice.exception.MyNullPointerException;
import az.unec.managerinfoservice.exception.ManagerNotFoundException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ManagersService {
    @Autowired
    private MangersRepo repo;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RabbitListener(queues = RabbitMqConfig.MANAGER_QUEUE_NAME)
    public void getClubNameAndSendMessageToClubQueue(String clubName) {
        ManagersDTO manager = getManager(clubName);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.CLUB_ROUTING_KEY,
                manager
        );

    }

    public ManagersDTO getManager(String name) {
        if (name == null || name.trim().length() < 3) {
            throw new MyNullPointerException("Please fill all fields");
        }
        Optional<ManagersDTO> manager = repo.findByClubName(name);
        manager.orElseThrow(() -> new ManagerNotFoundException("Manager Not Found"));
        return manager.get();
    }


}
