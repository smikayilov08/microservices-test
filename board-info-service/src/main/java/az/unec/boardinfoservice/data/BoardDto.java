package az.unec.boardinfoservice.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class BoardDto {
    private String executorName;
    private String title;
    private String clubName;
}
