package az.unec.managerinfoservice.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Managers {
    @Id
    @SequenceGenerator(name = "id_sequence",allocationSize = 1,initialValue = 1,sequenceName = "managers_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_sequence")
    private Integer id;
    private String managerName;
    private String nationality;
    @Column(unique = true)
    private String clubName;

    public Managers(String managerName,String nationality,String clubName){
        this.managerName=managerName;
        this.nationality=nationality;
        this.clubName=clubName;
    }
}
