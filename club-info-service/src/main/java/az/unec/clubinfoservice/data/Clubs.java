package az.unec.clubinfoservice.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Clubs {
    @Id
    @SequenceGenerator(name = "id_sequence", sequenceName = "clubs_id_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    private Integer id;
    @Column(unique = true)
    private String clubName;
    private String arena;
    private String city;
    private String countryName;
    private String leagueName;

}
