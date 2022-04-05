package az.unec.clubinfoservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class LeagueClubMQConfig {

    public static final String CLUB_QUEUE_NAME_2="club_queue";
    public static final String LEAGUE_CLUB_ROUTRING_KEY="league_club_routingKey";

    public static final String ALL_LEAGUE_CLUB_ROUTING_KEY="all_league_club_routingKey";
    public static final String ALL_CLUB_QUEUE_NAME="all_club_queue";


}
