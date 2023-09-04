package Services;
import Models.Match;
import Repositories.MatchOddsRepository;
import Repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/*
    Performing actions on the Match Model
*/

@Service
@Component
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;


    // Create a new match
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    // Get all matches
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    // Get match by ID
    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    // Update match
    public Match updateMatch(Long id, Match matchDetails) {
        Optional<Match> match = matchRepository.findById(id);
        if (match.isPresent()) {
            Match existingMatch = match.get();
            existingMatch.setDescription(matchDetails.getDescription());
            existingMatch.setMatch_time(matchDetails.getMatch_time());
            return matchRepository.save(existingMatch);
        }
        return null;
    }

    // Delete all matches
    public void deleteAllMatches() {
        matchRepository.deleteAll();
    }

    // Delete match
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}