package az.unec.popularteamservice.model;

import az.unec.popularteamservice.data.MostViewData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MostViewDto {
    List<MostViewData> mostView;
}
