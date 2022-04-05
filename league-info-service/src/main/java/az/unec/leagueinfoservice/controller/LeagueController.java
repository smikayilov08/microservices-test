package az.unec.leagueinfoservice.controller;

import az.unec.leagueinfoservice.model.data.LeagueData;
import az.unec.leagueinfoservice.service.LeagueService;
    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v2/leagues")
public class LeagueController {

    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("")
    public LeagueData getAll(final HttpServletResponse response) {
        return leagueService.getAll();
    }

    @GetMapping("/{league}/clubs")
    public ResponseEntity<?> getByLeagueName(@PathVariable String league,final HttpServletResponse response) {
        return ResponseEntity.ok(leagueService.getByLeagueNameClubs(league));
    }

    @GetMapping("/{league}/clubs/{club}")
    public ResponseEntity<?> getByLeagueNameAndClubName(@PathVariable String league,
                                                   @PathVariable String club) {

        return ResponseEntity.ok(leagueService.getByLeagueNameAndClubName(league, club));

    }


}
