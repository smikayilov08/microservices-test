package az.unec.managerinfoservice.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public interface MangersRepo extends CrudRepository<Managers, Integer> {
    Optional<ManagersDTO> findByClubName(String clubName);
}
