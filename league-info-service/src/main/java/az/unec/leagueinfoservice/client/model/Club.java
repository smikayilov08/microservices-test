package az.unec.leagueinfoservice.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Club {
    private String clubName;
    private String arena;
    private String city;
    private String countryName;
    private String leagueName;
}
