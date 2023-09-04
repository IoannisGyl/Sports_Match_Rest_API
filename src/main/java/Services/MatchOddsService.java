package Services;
import Models.MatchOdds;
import Repositories.MatchOddsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/*
    Performing actions on the Match Odds Model
*/

@Service
@Component
public class MatchOddsService {
    @Autowired
    private MatchOddsRepository matchOddsRepository;

    // Create a new matchOdds
    public MatchOdds createMatchOdds(MatchOdds matchOdds) {
        return matchOddsRepository.save(matchOdds);
    }

    // Get all matchOdds
    public List<MatchOdds> getAllMatchOdds() {
        return matchOddsRepository.findAll();
    }

    // Get matchOdds by ID
    public Optional<MatchOdds> getMatchOddsById(Long id) {
        return matchOddsRepository.findById(id);
    }

    // Update matchOdds
    public MatchOdds updateMatchOdds(Long id, MatchOdds matchOddsDetails) {
        Optional<MatchOdds> matchOdds = matchOddsRepository.findById(id);
        if (matchOdds.isPresent()) {
            MatchOdds existingMatchOdds = matchOdds.get();
            existingMatchOdds.setOdd(matchOddsDetails.getOdd());
            existingMatchOdds.setSpecifier(matchOddsDetails.getSpecifier());
            existingMatchOdds.setMatch_id(matchOddsDetails.getMatch_id());
            return matchOddsRepository.save(existingMatchOdds);
        }
        return null;
    }

    // Delete all matchOdds
    public void deleteAllMatchOdds() {
        matchOddsRepository.deleteAll();
    }

    // Delete matchOdds
    public void deleteMatchOdds(Long id) {
        matchOddsRepository.deleteById(id);
    }
}