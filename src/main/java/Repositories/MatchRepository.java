package Repositories;

import Models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/*
    Match repository with some custom find methods
*/
@Repository
public interface MatchRepository extends JpaRepository<Match, Long>, CrudRepository<Match,Long> {
    List<Match> findByteam_aOrteam_b(String teamName);

    List<Match> findBysport(int sport);

    List<Match> findBymatch_date(Date match_date);

}

