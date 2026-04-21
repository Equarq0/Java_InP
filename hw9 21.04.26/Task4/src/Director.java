import java.util.Objects;

class Director {
    int id;
    String name;
    int birthYear;

    public Director(int id, String name, int birthYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return id == director.id && birthYear == director.birthYear && Objects.equals(name, director.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthYear);
    }

    @Override
    public String toString() {
        return "Director{name='" + name + "'}";
    }
}