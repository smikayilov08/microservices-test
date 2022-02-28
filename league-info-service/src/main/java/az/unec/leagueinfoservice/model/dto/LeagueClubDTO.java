package az.unec.leagueinfoservice.model.dto;

import az.unec.leagueinfoservice.client.dto.ClubDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LeagueClubDTO {

    private LeagueDTO league;
    private List<ClubDTO> clubs;
}
