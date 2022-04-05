package az.unec.leagueinfoservice.model.data;

import az.unec.leagueinfoservice.model.dto.LeagueDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueData {

    private List<LeagueDTO> leagues;
}
