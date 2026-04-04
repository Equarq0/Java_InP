import java.util.function.Function;

public class Task2 {
    public static void main(String[] args) {
        Function<String, String> trimmer = s -> s.trim();
        Function<String, String> toLower = s -> s.toLowerCase();
        Function<String, String> firstUpper = s -> s.substring(0, 1).toUpperCase() + s.substring(1);

        Function<String, String> fullClean = trimmer.andThen(toLower).andThen(firstUpper);
        Function<String, String> quickClean = trimmer.andThen(toLower);

        String input = "  iVaN_iVaNoV  ";

        System.out.println(fullClean.apply(input));
        System.out.println(quickClean.apply(input));
    }
}