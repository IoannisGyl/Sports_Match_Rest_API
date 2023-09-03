package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Match {
    @Id
    private Long id;
    @Size(max = 200)
    private String description;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date match_date;
    @Size(max = 10)
    private String match_time;
    @Size(max = 50)
    private String team_a;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getMatch_date() {
        return match_date;
    }

    public void setMatch_date(Date match_date) {
        this.match_date = match_date;
    }

    public String getMatch_time() {
        return match_time;
    }

    public void setMatch_time(String match_time) {
        this.match_time = match_time;
    }

    public String getTeam_a() {
        return team_a;
    }

    public void setTeam_a(String team_a) {
        this.team_a = team_a;
    }

    public String getTeam_b() {
        return team_b;
    }

    public void setTeam_b(String team_b) {
        this.team_b = team_b;
    }

    @Size(max = 50)
    private String team_b;
    private enum Sport{
        FOOTBALL(1),
        BASKETBALL(2);

        public final int value;

        private Sport(int value){
            this.value = value;
        }
    }
}

