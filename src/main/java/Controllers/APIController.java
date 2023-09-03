package Controllers;

import Models.Match;
import Models.MatchOdds;
import Services.MatchOddsService;
import Services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@EnableJpaRepositories("Repositories")
@ComponentScan(basePackages = {"Services","Repositories","Models"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class APIController extends SpringBootServletInitializer {

    @Autowired
    private MatchService matchService;

    @Autowired
    private MatchOddsService matchOddsService;

    // Create a new match
    @PostMapping
    public Match createMatch(@RequestBody Match match) {
        return matchService.createMatch(match);
    }

    // Create a new matchOdds
    @PostMapping
    public MatchOdds createMatchOdds(@RequestBody MatchOdds matchOdds) {
        return matchOddsService.createMatchOdds(matchOdds);
    }

    // Get all matches
    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    // Get all matchOdds
    @GetMapping
    public List<MatchOdds> getAllMatchOdds() {
        return matchOddsService.getAllMatchOdds();
    }

    // Get match by ID
    @GetMapping("/{id}")
    public Optional<Match> getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    // Get matchOdds by ID
    @GetMapping("/{id}")
    public Optional<MatchOdds> getMatchOddsById(@PathVariable Long id) {
        return matchOddsService.getMatchOddsById(id);
    }

    // Update match by ID
    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable Long id, @RequestBody Match matchDetails) {
        return matchService.updateMatch(id, matchDetails);
    }

    // Update matchOdds by ID
    @PutMapping("/{id}")
    public MatchOdds updateMatchOdds(@PathVariable Long id, @RequestBody MatchOdds matchOddsDetails) {
        return matchOddsService.updateMatchOdds(id, matchOddsDetails);
    }

    // Delete all matches
    @DeleteMapping
    public String deleteAllMatches() {
        matchService.deleteAllMatches();
        return "All matches have been deleted successfully.";
    }

    // Delete all matchOdds
    @DeleteMapping
    public String deleteAllMatchOdds() {
        matchOddsService.deleteAllMatchOdds();
        return "All match odds have been deleted successfully.";
    }

    // Delete match by ID
    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
    }

    // Delete matchOdds by ID
    @DeleteMapping("/{id}")
    public void deleteMatchOdds(@PathVariable Long id) {
        matchOddsService.deleteMatchOdds(id);
    }

    public static void main(String[] args){
        SpringApplication.run(APIController.class, args);
    }
}

