package az.unec.popularteamservice.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class MostView {
    @Id
    @SequenceGenerator(name = "view_id",allocationSize = 1,sequenceName = "view_id_sequence")
    @GeneratedValue(generator = "view_id",strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String clubName;
    private Integer viewCount;

    public MostView(String clubName,Integer viewCount){
        this.clubName=clubName;
        this.viewCount=viewCount;
    }
}
