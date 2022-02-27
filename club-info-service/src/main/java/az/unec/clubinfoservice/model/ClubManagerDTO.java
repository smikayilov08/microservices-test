package az.unec.clubinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ClubManagerDTO {
    List<ManagerDTO> manager;
    List<ClubsDTO> club;
}
