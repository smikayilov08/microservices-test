package az.unec.leagueinfoservice.model.dto;

import az.unec.leagueinfoservice.client.dto.ClubDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueClubDTO {

    private LeagueDTO league;
    private List<ClubDTO> clubs;
}
