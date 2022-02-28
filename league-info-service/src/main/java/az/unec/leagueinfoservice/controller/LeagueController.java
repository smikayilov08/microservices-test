package az.unec.leagueinfoservice.controller;

import az.unec.leagueinfoservice.client.model.data.ClubManagerData;
import az.unec.leagueinfoservice.model.data.LeagueData;
import az.unec.leagueinfoservice.model.dto.LeagueClubDTO;
import az.unec.leagueinfoservice.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/league")
public class LeagueController {

    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/")
    public LeagueData getAll() {
        return leagueService.getAll();
    }

    @GetMapping("/{leagueName}")
    public LeagueClubDTO getByLeagueName(@PathVariable String leagueName) {
        return leagueService.getByLeagueNameClubs(leagueName);
    }

    @GetMapping("/{leagueName}/{clubName}")
    public ClubManagerData getByLeagueNameAndClubName(@PathVariable String leagueName,
                                                      @PathVariable String clubName) {
        return leagueService.getByLeagueNameAndClubName(leagueName, clubName);
    }
}
