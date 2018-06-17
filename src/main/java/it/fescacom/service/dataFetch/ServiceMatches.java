package it.fescacom.service.dataFetch;

import it.fescacom.domain.Match;

import java.util.List;

public abstract class ServiceMatches implements ServiceMatchesInterface {
    public abstract List<Match> fetchMatchData();
}
