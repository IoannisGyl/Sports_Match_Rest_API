package Repositories;


import Models.Match;
import Models.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/*
    Match Odds repository with a custom find method
*/
@Repository
public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long>, CrudRepository<MatchOdds,Long> {
    List<Match> findBymatch_id(int matchId);

}

