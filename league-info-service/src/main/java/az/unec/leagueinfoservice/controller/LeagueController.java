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

    @GetMapping("")
    public LeagueData getAll() {
        return leagueService.getAll();
    }

    @GetMapping("/club/{league}")
    public LeagueClubDTO getByLeagueName(@PathVariable String league) {
        return leagueService.getByLeagueNameClubs(league);
    }

    @GetMapping("/club/info/{league}/{club}")
    public ClubManagerData getByLeagueNameAndClubName(@PathVariable String league,
                                                      @PathVariable String club) {
        return leagueService.getByLeagueNameAndClubName(league, club);

    }
}
