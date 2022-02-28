package az.unec.clubinfoservice.controller;

import az.unec.clubinfoservice.model.ClubsDTO;
import az.unec.clubinfoservice.model.AllClubsDTO;
import az.unec.clubinfoservice.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClubController {
    @Autowired
    private ClubService service;

    @GetMapping("/club/{clubName}")
    public ClubsDTO clubInfo(@PathVariable String clubName){
        return service.club(clubName);
    }

    @GetMapping("/club")
    public AllClubsDTO clubsManagers(){
        return service.allClub();
    }

}
