package az.unec.leagueinfoservice.dao.repository;

import az.unec.leagueinfoservice.dao.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {

    Optional<League> findByLeagueName(String name);
}
