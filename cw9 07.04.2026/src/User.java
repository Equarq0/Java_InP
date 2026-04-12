import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private int age;
    private String country;
    private List<Movie> films;

    public User(int id, String name, int age, String country, List<Movie> films) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.films = films;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFilms(List<Movie> films) {
        this.films = films;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Movie> getFilms() {
        return films;
    }
}
