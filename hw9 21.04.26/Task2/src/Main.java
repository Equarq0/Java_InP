import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Team> teams = DataGenerator_Task2.generateTeams();
        List<Player> players = DataGenerator_Task2.generatePlayers();
        teams.forEach(p -> System.out.println(p));

    }
}