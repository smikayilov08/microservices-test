package az.unec.clubinfoservice.service;

import az.unec.clubinfoservice.exceptoin.ClubNotFoundException;
import az.unec.clubinfoservice.exceptoin.MyNullPointerException;
import az.unec.clubinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    @Autowired
    private ClubsRepo repo;

    @Autowired
    private ManagerService managerService;

    public ClubsDTO club(String clubName) {
        if (clubName == null || clubName.trim().length() < 3) {
            throw new MyNullPointerException("Please fill all fields");
        }

        Optional<ClubsDTO> club = repo.findByClubName(clubName);
        club.orElseThrow(() -> new ClubNotFoundException("Club doesn't exist"));

        managerService.setManagerQueue(clubName);

        ManagerDTO manager =managerService.getManagerFromQueue();
        club.get().setManager(manager);

        return club.get();
    }


    public AllClubsDTO allClub() {
        Optional<List<ClubInfoDTO>> clubs = repo.findByClubNameNotNull();
        clubs.orElseThrow(() -> new ClubNotFoundException("Clubs not found"));
        if (!clubs.isPresent()) {
            throw new ClubNotFoundException("Clubs not found");
        }

        AllClubsDTO clubsManagers = new AllClubsDTO(clubs.get());

        return clubsManagers;
    }

}
