package az.unec.clubinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDTO {
    private  String managerName;
    private  String nationality;
    private String clubName;
}
