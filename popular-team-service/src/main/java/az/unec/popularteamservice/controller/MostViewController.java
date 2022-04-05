package az.unec.popularteamservice.controller;

import az.unec.popularteamservice.model.MostViewDto;
import az.unec.popularteamservice.service.ReciverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v3/clubs")
public class MostViewController {

    @Autowired
    private ReciverService reciverService;

    @GetMapping("/most-viewed")
    public MostViewDto getView(){
        return reciverService.getMostView();
    }
}
