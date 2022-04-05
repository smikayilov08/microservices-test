package az.unec.leagueinfoservice.client.dto;

import az.unec.leagueinfoservice.client.model.BoardDto;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDtoList {
    private List<BoardDto> boards;
}
