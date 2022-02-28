package az.unec.leagueinfoservice.model.dto;

import az.unec.leagueinfoservice.dao.entity.League;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueDTO {

    private String leagueName;
    private String country;

    public LeagueDTO(League league){
        this.leagueName = league.getLeagueName();
        this.country = league.getCountry();
    }
}
