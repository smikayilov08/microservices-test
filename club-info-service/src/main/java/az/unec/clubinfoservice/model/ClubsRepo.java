package az.unec.clubinfoservice.model;

import az.unec.clubinfoservice.data.Clubs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubsRepo extends CrudRepository<Clubs,Integer> {
    Optional<ClubsDTO> findByClubName(String clubName);

    Optional<List<ClubInfoDTO>> findByClubNameNotNull();
}
