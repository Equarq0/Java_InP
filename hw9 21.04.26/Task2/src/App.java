import java.util.*;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {
		List<Team> teams = DataGenerator_Task2.generateTeams();
        List<Player> players = DataGenerator_Task2.generatePlayers();

		// Task1
		System.out.println("Task1");

		List<String> lst = players.stream().map(p -> "Nick: " + p.getNickname() + " Age: " + p.getAge() + " Team: " + (teams.stream().filter(x -> x.getId() == p.getTeamId())).map(z -> z.getName()).findFirst().orElse("")).toList();
		lst.forEach(x -> System.out.println(x));
		Map<Integer, Team> teamMap = teams.stream()
				.collect(Collectors.toMap(Team::getId, t -> t));
		// Task 2
		System.out.println("\nTask2");
		Map<String, Double> avgRatings = players.stream()
				.collect(Collectors.groupingBy(
						p -> teamMap.get(p.getTeamId()).getName(),
						Collectors.averagingDouble(Player::getRating)
				));
		System.out.println(avgRatings);

		// Task 3
		System.out.println("\nTask3");
		players.stream()
				.filter(p -> p.getAge() >= 21)
				.sorted(Comparator.comparingDouble(Player::getRating).reversed())
				.limit(3)
				.forEach(System.out::println);

		// Task 4
		System.out.println("\nTask4");
		Player youngest = Collections.min(players, Comparator.comparingInt(Player::getAge));
		System.out.println(youngest);

		// Task 5
		System.out.println("\nTask5");
		Map<Integer, String> playerIdToNick = players.stream()
				.collect(Collectors.toMap(Player::getId, Player::getNickname));
		System.out.println(playerIdToNick);

		// Task 6
		System.out.println("\nTask6");
		Map<Team, List<Player>> playersByTeam = players.stream()
				.collect(Collectors.groupingBy(p -> teamMap.get(p.getTeamId())));

		List<String> allNicknames = playersByTeam.values().stream()
				.flatMap(Collection::stream)
				.map(Player::getNickname)
				.collect(Collectors.toList());

		System.out.println(playersByTeam);
		System.out.println(allNicknames);
	}
}