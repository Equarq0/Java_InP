import java.util.Objects;

public class Player {
	int id;
	String nickname;
	int age;
	int teamId;
	double rating;

	public Player(int id, String nickname, int age, int teamId, double rating) {
		this.id = id;
		this.teamId = teamId;
		this.nickname = nickname;
		this.age = age;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public int getTeamId() {
		return teamId;
	}
	public String getNickname() {
		return nickname;
	}
	public double getRating() {
		return rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nickname, age, teamId, rating);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null || o.getClass() != this.getClass()) return false;
		Player player = (Player) o;
		return player.id == id && nickname.equals(player.nickname) && age == player.age && teamId == player.teamId && Double.compare(player.rating, rating) == 0;
	}

	@Override
	public String toString() {
		return id + " " + nickname + " " + age + " " + teamId + " " + rating;
	}
}