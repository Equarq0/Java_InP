import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Director> directorList = DataGenerator_Task4.generateDirectors();
        List<Movie> movieList = DataGenerator_Task4.generateMovies();

        Map<Integer, Director> dirMap = directorList.stream()
                .collect(Collectors.toMap(Director::getId, d -> d));

        // Task 1
        System.out.println("Task1");
        movieList.stream()
                .map(m -> String.format("Фильм: %s (%d), Режиссёр: %s, Рейтинг: %.1f",
                        m.getTitle(), m.getYear(), dirMap.get(m.getDirectorId()).getName(), m.getRating()))
                .forEach(System.out::println);

        // Task 2
        System.out.println("\nTask2");
        Map<String, Double> avgRatingByDirector = movieList.stream()
                .collect(Collectors.groupingBy(
                        m -> dirMap.get(m.getDirectorId()).getName(),
                        Collectors.averagingDouble(Movie::getRating)
                ));
        System.out.println(avgRatingByDirector);

        // Task 3
        System.out.println("\nTask3");
        movieList.stream()
                .filter(m -> m.getYear() > 2010)
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(3)
                .forEach(System.out::println);

        // Task 4
        System.out.println("\nTask4");
        Movie worstMovie = Collections.min(movieList, Comparator.comparingDouble(Movie::getRating));
        System.out.println(worstMovie);

        // Task 5
        System.out.println("\nTask5");
        Map<String, Double> movieToRating = movieList.stream()
                .collect(Collectors.toMap(
                        Movie::getTitle,
                        Movie::getRating,
                        (r1, r2) -> r1 // На случай, если есть фильмы с одинаковым названием
                ));
        System.out.println(movieToRating);

        // Task 6
        System.out.println("\nTask6");
        Map<Director, List<Movie>> moviesByDirector = movieList.stream()
                .collect(Collectors.groupingBy(m -> dirMap.get(m.getDirectorId())));

        List<String> allTitles = moviesByDirector.values().stream()
                .flatMap(Collection::stream)
                .map(Movie::getTitle)
                .collect(Collectors.toList());

        System.out.println(moviesByDirector);
        System.out.println(allTitles);
    }
}