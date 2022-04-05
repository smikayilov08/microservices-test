package az.unec.boardinfoservice.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Board {
    @Id
    @SequenceGenerator(name = "country_id_sequence",allocationSize = 1,sequenceName = "country_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "country_id_sequence")
    private int id;
    private String executorName;
    private String title;
    private String clubName;
}
