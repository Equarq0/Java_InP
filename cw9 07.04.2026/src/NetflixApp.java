import java.util.*;
import java.util.stream.Collectors;

public class NetflixApp {

    public static void main(String[] args) {
        List<Movie> movies = NetflixDataGenerator.generateMovies();
        List<User> users = NetflixDataGenerator.generateUsers(movies);
        users.add(new User(100, "pepe", 20, "RUSSIA", new ArrayList<>()));

        // Здесь вы пишете свои решения:
        // tasksA(users, movies); tasksB(...); и т.д.
        System.out.println("Movies: " + movies.size());
        System.out.println("Users: " + users.size());

        // Task1
        // users.stream().flatMap(f -> f.getFilms().stream()).distinct().map(Movie::getName).sorted().toList().forEach(r -> System.out.println(r));

        // Task2
//        movies.stream().filter(p -> p.getRating() > 8.0).sorted(new Comparator<>() {
//            @Override
//            public int compare(Movie o1, Movie o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        }).sorted(new Comparator<>() {
//            @Override
//            public int compare(Movie o1, Movie o2) {
//                return Double.compare(o2.getRating(), o1.getRating());
//            }
//        }).forEach(res -> System.out.println(res.getName() + " " + res.getRating()));

        // Task3
        // users.stream().filter(user -> user.getAge() > 18).filter(user -> !user.getFilms().isEmpty()).forEach(f -> System.out.println(f.getName()));


        // Task4
        // System.out.println(users.stream().flatMap(film -> film.getFilms().stream()).toList().size());

        // Part3

        // Task1
//          Map<String, List<Movie>> data = users.stream().flatMap(f -> f.getFilms().stream()).collect(Collectors.groupingBy(film -> film.getGenre()));
//          System.out.println(data);

        // Task2
//        Map<String, Long> data = users.stream().flatMap(f -> f.getFilms().stream()).collect(Collectors.groupingBy(film -> film.getGenre(), Collectors.counting()));
//        System.out.println(data);

        // Task3
//        Map<User, Long> data = users.stream().collect(Collectors.toMap(user -> user, user -> (long) user.getFilms().size()));
//        System.out.println(data);

        // Task4
        Map<User, Optional<Movie>> data = users.stream().collect(Collectors.toMap(user -> user, user -> user.getFilms().stream().max(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return Double.compare(o1.getDuration(), o2.getDuration());
            }
        })));
        System.out.println(data);

    }
}
