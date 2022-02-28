package az.unec.leagueinfoservice.client.dto;

import az.unec.leagueinfoservice.client.model.Club;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClubDTO {
    private String clubName;
    private String arena;
    private String city;

    public ClubDTO(Club club){
        this.clubName = club.getClubName();
        this.arena = club.getArena();
        this.city = club.getCity();
    }
}
