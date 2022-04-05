package az.unec.boardinfoservice.model;

import az.unec.boardinfoservice.data.Board;
import az.unec.boardinfoservice.data.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubBoardRepo extends JpaRepository<Board,Integer> {
    Optional<List<BoardDto>> findByClubName(String clubName);
}
