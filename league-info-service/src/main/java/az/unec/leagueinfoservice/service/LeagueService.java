package az.unec.leagueinfoservice.service;

import az.unec.leagueinfoservice.client.model.data.ClubManagerData;
import az.unec.leagueinfoservice.model.data.LeagueData;
import az.unec.leagueinfoservice.model.dto.LeagueClubDTO;

public interface LeagueService {

    LeagueData getAll();

    LeagueClubDTO getByLeagueNameClubs(String leagueName);

    ClubManagerData getByLeagueNameAndClubName(String leagueName, String clubName);
}
