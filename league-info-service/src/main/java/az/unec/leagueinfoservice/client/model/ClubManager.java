package az.unec.leagueinfoservice.client.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClubManager {
    private String clubName;
    private String arena;
    private String city;
    private String countryName;
    private String leagueName;
    private Manager manager;
}
