package az.unec.popularteamservice.service;

import az.unec.popularteamservice.config.RabbitMQConfig;
import az.unec.popularteamservice.data.MostView;
import az.unec.popularteamservice.data.MostViewData;
import az.unec.popularteamservice.model.MostViewDto;
import az.unec.popularteamservice.model.MostViewRepo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciverService {

    @Autowired
    private MostViewRepo viewRepo;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void getString(String clubName){
        MostView viewTeam =null;
        try {
           viewTeam=viewRepo.findByClubName(clubName);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (viewTeam==null){
            viewRepo.save(new MostView(clubName,1));
        }
        else{
            viewTeam.setViewCount(viewTeam.getViewCount()+1);
            viewRepo.save(viewTeam);
        }
    }

    public MostViewDto getMostView(){
        List<MostViewData> data=viewRepo.getMostViewed();
        MostViewDto viewDto=new MostViewDto(data);
        return viewDto;
    }
}
