import java.util.Objects;

public class Team {
	int id;
	String name;
	String country;
	int ranking;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public Team(int id, String name, String country, int ranking) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.ranking = ranking;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, country, ranking);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || this.getClass() != o.getClass()) return false;
		if (o == this) return true;
		Team team = (Team) o;
		return team.id == this.id && name.equals(team.name) && country.equals(team.country) && team.ranking == this.ranking;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + country + " " + ranking;
	}
}