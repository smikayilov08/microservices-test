package az.unec.boardinfoservice.service;

import az.unec.boardinfoservice.data.BoardDto;
import az.unec.boardinfoservice.data.BoardDtoList;
import az.unec.boardinfoservice.model.ClubBoardRepo;
import az.unec.boardinfoservice.model.exception.ClubBoardNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClubBoardService {

    @Autowired
    private ClubBoardRepo repo;

    public BoardDtoList getBoard(String clubName) {
        Optional<List<BoardDto>> boardDtoList = repo.findByClubName(clubName);
        boardDtoList.orElseThrow(() -> new ClubBoardNotFound("Board not found"));

        if (boardDtoList.get().isEmpty()) {
            throw new ClubBoardNotFound("Board not found");
        }

        return new BoardDtoList(boardDtoList.get());
    }


}
