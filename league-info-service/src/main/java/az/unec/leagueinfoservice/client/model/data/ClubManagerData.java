package az.unec.leagueinfoservice.client.model.data;

import az.unec.leagueinfoservice.client.dto.ClubManagerDTO;
import az.unec.leagueinfoservice.model.dto.LeagueDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClubManagerData {

    private LeagueDTO league;
    private ClubManagerDTO club;
}
