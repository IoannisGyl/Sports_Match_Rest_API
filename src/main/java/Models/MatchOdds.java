package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
    Match Odds model definition
*/
@Entity
public class MatchOdds {
    @Id
    private Long id;
    private int match_id;
    @Size(max = 10)
    private String specifier;
    private Double odd;

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }
}
