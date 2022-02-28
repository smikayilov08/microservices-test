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
import az.unec.leagueinfoservice.model.exceptions.ClubNotFoundException;
import az.unec.leagueinfoservice.model.exceptions.LeagueNotFoundException;
import az.unec.leagueinfoservice.model.exceptions.ManagerNotFoundException;
import az.unec.leagueinfoservice.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
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
        return new LeagueData(leagueRepository.findAll().parallelStream().map((LeagueDTO::new)).collect(Collectors.toList()));
    }

    @Override
    public LeagueClubDTO getByLeagueNameClubs(String leagueName) {
        League league = leagueRepository.findByLeagueName(leagueName).orElseThrow(() -> new LeagueNotFoundException("League Not Found"));
        ClubData clubData = restTemplate.getForObject("http://club-info-service/club", ClubData.class);
        assert clubData != null;
        List<ClubDTO> clubDTOList = clubData.getClubs().parallelStream().filter(club -> club.getLeagueName().equalsIgnoreCase(league.getLeagueName())).map(ClubDTO::new).collect(Collectors.toList());
        return new LeagueClubDTO(new LeagueDTO(league), clubDTOList);
    }

    @Override
    public ClubManagerData getByLeagueNameAndClubName(String leagueName, String clubName) {
        LeagueClubDTO leagueClubDTO = getByLeagueNameClubs(leagueName);
        ClubManager clubManager;
        try {
            clubManager = restTemplate.getForObject("http://club-info-service/club/" + clubName, ClubManager.class);
        } catch (HttpClientErrorException ex) {
            if (Objects.requireNonNull(ex.getMessage()).contains("Club doesn't exist")) {
                throw new ClubNotFoundException("Club doesn't exist");
            } else {
                throw new ManagerNotFoundException("Manager doesn't exist");
            }
        }
        ClubManagerDTO clubManagerDTO = leagueClubDTO.getClubs().parallelStream()
                .filter(clubDTO -> clubDTO.getClubName().equalsIgnoreCase(clubManager.getClubName()))
                .map((clubDTO) -> new ClubManagerDTO(clubManager))
                .findAny().get();
        return new ClubManagerData(leagueClubDTO.getLeague(), clubManagerDTO);
    }
}

