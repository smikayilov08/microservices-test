package az.unec.leagueinfoservice.service.impl;

import az.unec.leagueinfoservice.client.dto.ClubDTO;
import az.unec.leagueinfoservice.client.dto.ClubManagerDTO;
import az.unec.leagueinfoservice.client.model.ClubManager;
import az.unec.leagueinfoservice.client.model.data.ClubData;
import az.unec.leagueinfoservice.client.model.data.ClubManagerData;
import az.unec.leagueinfoservice.dao.entity.League;
import az.unec.leagueinfoservice.dao.repository.LeagueRepository;
import az.unec.leagueinfoservice.model.data.LeagueData;
import az.unec.leagueinfoservice.model.dto.LeagueClubDTO;
import az.unec.leagueinfoservice.model.dto.LeagueDTO;
import az.unec.leagueinfoservice.model.exceptions.LeagueNotFoundException;
import az.unec.leagueinfoservice.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;

    private final RestTemplate restTemplate;

    @Autowired
    public LeagueServiceImpl(LeagueRepository leagueRepository, RestTemplate restTemplate) {
        this.leagueRepository = leagueRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public LeagueData getAll() {
        return new LeagueData(leagueRepository.findAll().parallelStream()
                .map((LeagueDTO::new)).collect(Collectors.toList()));
    }

    @Override
    public LeagueClubDTO getByLeagueNameClubs(String leagueName) {
        League league = leagueRepository.findByLeagueName(leagueName).orElseThrow(LeagueNotFoundException::new);
        ClubData clubData = restTemplate.getForObject("http://localhost:8081/club", ClubData.class);
        assert clubData != null;
        List<ClubDTO> clubDTOList = clubData.getClubs().parallelStream()
                .filter(club -> club.getLeagueName().equalsIgnoreCase(league.getLeagueName()))
                .map(ClubDTO::new)
                .collect(Collectors.toList());
        return new LeagueClubDTO(new LeagueDTO(league), clubDTOList);
    }

    @Override
    public ClubManagerData getByLeagueNameAndClubName(String leagueName, String clubName) {
        LeagueClubDTO leagueClubDTO = getByLeagueNameClubs(leagueName);
        ClubManager clubManager = restTemplate.getForObject("http://localhost:8081/club/" + clubName, ClubManager.class);
        ClubManagerDTO clubManagerDTO = leagueClubDTO.getClubs().parallelStream()
                .filter(clubDTO -> {
                    assert clubManager != null;
                    return clubDTO.getClubName().equalsIgnoreCase(clubManager.getClubName());
                })
                .map((clubDTO) -> new ClubManagerDTO(clubManager))
                .collect(Collectors.toList()).get(0);
        return new ClubManagerData(leagueClubDTO.getLeague(), clubManagerDTO);
    }
}

