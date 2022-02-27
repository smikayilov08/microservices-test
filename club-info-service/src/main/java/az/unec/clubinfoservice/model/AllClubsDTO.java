package az.unec.clubinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class AllClubsDTO {
    private List<ClubInfoDTO> clubs;
}
