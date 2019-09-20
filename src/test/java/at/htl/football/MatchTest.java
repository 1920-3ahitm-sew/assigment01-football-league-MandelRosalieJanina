package at.htl.football;

import org.junit.jupiter.api.Test;




import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MatchTest {

    @Test

    public void homeTeam_wins(){
        Match match = new Match("Bayern Munich","Hoffenheim",5,3);

        assertThat(match.getHomePoints(), is(3));
        assertThat(match.getGuestPoints(), is(0));
    }

    @Test
    public void guestTeam_wins() {
        Match match = new Match("Bayern Munich","Hoffenheim",2,3);

        assertThat(match.getHomePoints(), is(0));
        assertThat(match.getGuestPoints(), is(3));
    }

    @Test
    public void samePoints(){
        Match match = new Match("Bayern Munich","Hoffenheim",5,5);

        assertThat(match.getHomePoints(), is(1));
        assertThat(match.getGuestPoints(), is(1));
    }
}