import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products1 = new ArrayList<>(Arrays.asList(new Product(1, "PineApple", 100),
                new Product(2, "Apple", 200),
                new Product(5, "Энергетик", 300)));

        List<Product> products2 = new ArrayList<>(Arrays.asList(new Product(1, "Хлеб", 50),
                new Product(3, "Булка", 150),
                new Product(4, "Батон", 250),
                new Product(10, "Pupupu", 350)));

        List<Product> products3 = new ArrayList<>(Arrays.asList(new Product(1, "Корица", 10),
                new Product(6, "Сахар", 20),
                new Product(3, "Энергетик", 30)));

        ArrayList<Order> orders = new ArrayList<>(Arrays.asList(new Order(1, new User(1, "Danil"), products1, LocalDateTime.now().minusDays(10)),
                new Order(2, new User(2, "Kirill"), products2, LocalDateTime.now().minusDays(20)),
                new Order(3, new User(3, "Evelina"), products3, LocalDateTime.now().minusDays(30))));

        // Task1
        orders.stream().filter(p -> p.getProducts().stream().anyMatch(pp -> pp.getName().equals("Энергетик"))).filter(order -> order.getOrderDate().isAfter(LocalDateTime.now().minusDays(30))  ).forEach(p -> System.out.println(p));

        // Task2
        Map<String, Double> m = orders.stream().flatMap(order -> order.getProducts().stream()).collect(Collectors.groupingBy(Product::getName, Collectors.summingDouble(Product::getPrice)));
        System.out.println(m);
    }
}