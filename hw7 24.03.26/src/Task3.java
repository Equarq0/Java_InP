import java.util.function.Predicate;

public class Task3 {
    public static void main(String[] args) {
        Predicate<String> isShort = s -> s.length() < 5;
        Predicate<String> hasSpam = s -> s.toLowerCase().contains("buy");
        Predicate<String> isCaps = s -> s.equals(s.toUpperCase());

        Predicate<String> complexRule = isShort.negate().and(isCaps.or(hasSpam));

        checkComment("HI", complexRule);
        checkComment("buy pup", complexRule);
        checkComment("Hello world", complexRule);
        checkComment("КАПС И ДЛИННОЕ", complexRule);
    }

    public static void checkComment(String text, Predicate<String> rule) {
        if (rule.test(text)) {
            System.out.println(text + ": Удалено");
        } else {
            System.out.println(text + ": Одобрено");
        }
    }
}