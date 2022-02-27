package az.unec.leagueinfoservice.controller;

import az.unec.leagueinfoservice.client.model.data.ClubManagerData;
import az.unec.leagueinfoservice.model.data.LeagueData;
import az.unec.leagueinfoservice.model.dto.LeagueClubDTO;
import az.unec.leagueinfoservice.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/league")
public class LeagueController {

    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/all")
    public LeagueData getAll() {
        return leagueService.getAll();
    }

    @GetMapping("/club")
    public LeagueClubDTO getByLeagueName(@RequestParam String leagueName) {
        return leagueService.getByLeagueNameClubs(leagueName);
    }

    @GetMapping("/club/one")
    public ClubManagerData getByLeagueNameAndClubName(@RequestParam String leagueName,
                                                      @RequestParam String clubName) {
        return leagueService.getByLeagueNameAndClubName(leagueName, clubName);

    }
}
