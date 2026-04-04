import java.util.function.Consumer;
import java.util.function.Function;

public class Task1 {
    public static void main(String[] args) {
        Function<String, Function<String, Consumer<String>>> createNotifier = token -> chatId -> message -> {
            System.out.println("msg: " + message);
        };

        Consumer<String> myNotifier = createNotifier.apply("ToToken").apply("1");

        processOrder("Картошка", myNotifier);



    }

    public static void processOrder(String item, Consumer<String> sender) {
        System.out.println("Товар: " + item);
        sender.accept("Заказ на '" + item + "'");
    }
}