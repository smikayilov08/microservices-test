package az.unec.clubinfoservice.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClubsDTO {
    private String clubName;
    private String arena;
    private String city;
    private String countryName;
    private String leagueName;

    public ClubsDTO(String clubName, String arena, String city, String countryName, String leagueName) {
        this.clubName = clubName;
        this.arena = arena;
        this.city = city;
        this.countryName = countryName;
        this.leagueName = leagueName;
    }

    private ManagerDTO manager;
}
