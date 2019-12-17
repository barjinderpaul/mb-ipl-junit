import com.company.Match;
import com.company.ReadInput;
import com.company.SolveScenarios;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SolveScenariosTest {
    ReadInput readInput = new ReadInput();
    SolveScenarios solved = new SolveScenarios();

//    @Test
//   void checkAssertTrue() {
//        assertTrue(1==1, "This is true");
//    }
//
//    @Test
//    void checkAssertFalse() {
//        assertFalse(1==2,"This will be false");
//    }
//
//    @Test
//    void checkAssertEquals() {
//        assertEquals(1,2,"This will throw AssertionError");
//    }

    @Test
    void matchesPlayedPerYear() {
        List<Match> matchData = readInput.getMatchData("matchesPlayedPerSeasonTest.csv");

        Map<String, Integer> matchesPlayedPerSeason = solved.matchesPlayedPerYear(matchData);

        assertEquals(3, matchesPlayedPerSeason.get("2017"));
        assertEquals(6, matchesPlayedPerSeason.get("2008"));
    }
    @Test
    void test_MatchesWonOfAllTeams_CorrectInput() {
        List<Match> matchData = readInput.getMatchData("matchesWonTest.csv");

        Map<String, Integer> matchesWon = solved.matchesWonOfAllTeams(matchData);

        assertEquals(2, matchesWon.get("Sunrisers Hyderabad"));
        assertEquals(4, matchesWon.get("Mumbai Indians"));
    }

    @Test
    void test_MatchesWonOfAllTeams_NullInput() {
        List<Match> matchData = readInput.getMatchData("matchesWonTestNullInput.csv");

        Map<String, Integer> matchesWon = solved.matchesWonOfAllTeams(matchData);

        assertEquals(null, matchesWon.get("Sunrisers Hyderabad"));
        assertEquals(null, matchesWon.get("Mumbai Indians"));
    }

    @Test
    void test_MatchesWonOfAllTeams_IncorrectFileInput() {
        List<Match> matchData = readInput.getMatchData("some_random_file_which_is_not_present.csv");

        Map<String, Integer> matchesWon = solved.matchesWonOfAllTeams(matchData);

        assertEquals(null, matchesWon.get("Mumbai Present"));
    }

    @Test
    void test_MatchesWonOfAllTeams_InvalidSplittedFileInput() {
        List<Match> matchData = readInput.getMatchData("invalid_delimeter_file.txt");

        Map<String, Integer> matchesWon = solved.matchesWonOfAllTeams(matchData);

        assertEquals(4, matchesWon.get("Mumbai Indians"));
    }




}