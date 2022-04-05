package az.unec.popularteamservice.model;

import az.unec.popularteamservice.data.MostView;
import az.unec.popularteamservice.data.MostViewData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MostViewRepo extends CrudRepository<MostView,Integer> {

    MostView findByClubName(String clubName);


    @Query(nativeQuery=true,value="select  club_name as ClubName,view_count as ViewCount from  most_view order by view_count desc limit 3 ")
    List<MostViewData> getMostViewed();
}
