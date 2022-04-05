package az.unec.leagueinfoservice.client.dto;

import az.unec.leagueinfoservice.client.model.ClubManager;
import az.unec.leagueinfoservice.client.model.Manager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClubManagerDTO {
    private String clubName;
    private String arena;
    private String city;
    private ManagerDTO manager;


    public ClubManagerDTO(ClubManager clubManager,Manager manager) {
        this.clubName = clubManager.getClubName();
        this.arena = clubManager.getArena();
        this.city = clubManager.getCity();
        this.manager = new ManagerDTO(manager);
    }
    public ClubManagerDTO(ClubManager clubManager){
        this.clubName = clubManager.getClubName();
        this.arena = clubManager.getArena();
        this.city = clubManager.getCity();
    }
    public ClubManagerDTO(Manager manager){
        this.manager=new ManagerDTO(manager);
    }
}
