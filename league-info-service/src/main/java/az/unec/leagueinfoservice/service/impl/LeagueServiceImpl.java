package az.unec.leagueinfoservice.service.impl;

import az.unec.leagueinfoservice.client.dto.BoardDtoList;
import az.unec.leagueinfoservice.client.dto.ClubDTO;
import az.unec.leagueinfoservice.client.dto.ClubManagerDTO;
import az.unec.leagueinfoservice.client.model.ClubManager;
import az.unec.leagueinfoservice.client.model.data.ClubData;
import az.unec.leagueinfoservice.client.model.data.ClubInfoData;
import az.unec.leagueinfoservice.dao.entity.League;
import az.unec.leagueinfoservice.dao.repository.LeagueRepository;
import az.unec.leagueinfoservice.model.data.LeagueData;
import az.unec.leagueinfoservice.model.dto.LeagueClubDTO;
import az.unec.leagueinfoservice.model.dto.LeagueDTO;
import az.unec.leagueinfoservice.model.exceptions.LeagueNotFoundException;
import az.unec.leagueinfoservice.service.AllClubService;
import az.unec.leagueinfoservice.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueServiceImpl implements LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;


    @Autowired
    private AllClubService allClubService;

    @Autowired
    private ClubService clubService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private TopTeamService teamService;

    @Override
    public LeagueData getAll() {
        return new LeagueData(leagueRepository.findAll().parallelStream().map((LeagueDTO::new)).collect(Collectors.toList()));
    }

    @Override
    public LeagueClubDTO getByLeagueNameClubs(String leagueName) {

        League league = leagueRepository.findByLeagueName(leagueName).orElseThrow(() -> new LeagueNotFoundException("League Not Found"));

        allClubService.setAllClubQueue();

        ClubData clubData = allClubService.getAllClubfromAllClubQueue();


        List<ClubDTO> clubDTOList = new ArrayList<>();
        if(clubData==null){
            clubDTOList=null;
        }
        else if(clubData.getClubs()!=null){
            clubDTOList=clubData.getClubs().parallelStream().
                    filter(club -> club.getLeagueName().equalsIgnoreCase(league.getLeagueName())).map(ClubDTO::new).
                    collect(Collectors.toList());
        }
        return new LeagueClubDTO(new LeagueDTO(league), clubDTOList);
    }


    @Override
    public ClubInfoData getByLeagueNameAndClubName(String leagueName, String clubName) {

        teamService.sendClubToTeamQueue(clubName);

        clubService.setClubQueue(clubName);

        LeagueClubDTO leagueClubDTO = getByLeagueNameClubs(leagueName);

        ClubManager clubManager =clubService.getClubAndManagerFromClubQueue();

        boardService.sendClubNameToBoardQueue(clubName);
        BoardDtoList boardDtoList =boardService.getBoardFromLeagueBoardQueue();

        if((clubManager!=null && !clubManager.getCountryName().equals(leagueClubDTO.getLeague().getCountry()))
            || leagueClubDTO.getClubs()==null){
            return new ClubInfoData(leagueClubDTO.getLeague(), null, boardDtoList);
        }

        ClubManagerDTO clubManagerDTO=
                leagueClubDTO.getClubs().parallelStream()
                        .filter(clubDTO -> clubManager!=null)
                        .filter(clubDTO ->clubManager.getClubName()!=null && clubManager.getManager()!=null )
                        .filter(clubDTO -> clubDTO.getClubName().equalsIgnoreCase(clubManager.getClubName()))
                        .map((clubDTO) -> new ClubManagerDTO(clubManager,clubManager.getManager()))
                        .findAny().orElseGet(()->{
                         if(clubManager==null){
                             return new ClubManagerDTO();
                         }
                    else if (clubManager.getManager()!=null){
                        return new ClubManagerDTO(clubManager.getManager());
                    }
                    else if(clubManager.getClubName()!=null){
                        return new ClubManagerDTO(clubManager);
                    }
                    else
                        return null;
                });



        return new ClubInfoData(leagueClubDTO.getLeague(), clubManagerDTO, boardDtoList);
    }
}

