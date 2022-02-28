package az.unec.leagueinfoservice.client.model.data;

import az.unec.leagueinfoservice.client.model.Club;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClubData {

    private List<Club> clubs;
}
