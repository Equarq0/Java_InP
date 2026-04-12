import java.util.*;
import java.util.stream.Collectors;

public class OrderAnalysis {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>(Arrays.asList(new User(2, "Kirill"),
                new User(1, "Danil"),
                new User(3, "Evelina")));

        List<Product> products1 = new ArrayList<>(Arrays.asList(new Product(1, "PineApple"),
                new Product(2, "Apple"),
                new Product(5, "Cheese")));

        List<Product> products2 = new ArrayList<>(Arrays.asList(new Product(1, "Хлеб"),
                new Product(3, "Булка"),
                new Product(4, "Батон"),
                new Product(10, "Pupupu")));

        List<Product> products3 = new ArrayList<>(Arrays.asList(new Product(1, "Корица"),
                new Product(6, "Сахар"),
                new Product(3, "Булка")));

        ArrayList<Order> orders = new ArrayList<>(Arrays.asList(new Order(1, new User(1, "Danil"), products1),
                new Order(2, new User(2, "Kirill"), products2),
                new Order(3, new User(3, "Evelina"), products3)));

        orders.stream().flatMap(order -> order.getProducts().stream()).collect(Collectors.toSet()).forEach(p -> System.out.println(p.getName()));
        System.out.println("---------------------");
        Map<String, Long> products = orders.stream().flatMap(order -> order.getProducts().stream()).collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
        System.out.println(products);

        System.out.println("---------------------");
        orders.stream().sorted().findFirst().ifPresentOrElse(student -> System.out.println(student.getProducts()), () -> System.out.println("Нет такого"));

    }
}
