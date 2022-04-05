package az.unec.leagueinfoservice.client.model;

import lombok.*;


@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class BoardDto {
    private String executorName;
    private String title;
    private String clubName;
}
