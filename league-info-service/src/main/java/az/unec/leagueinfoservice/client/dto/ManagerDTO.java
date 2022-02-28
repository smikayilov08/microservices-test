package az.unec.leagueinfoservice.client.dto;

import az.unec.leagueinfoservice.client.model.Manager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDTO {
    private String managerName;
    private String nationality;

    public ManagerDTO(Manager manager){
        this.managerName = manager.getManagerName();
        this.nationality = manager.getNationality();
    }
}
