import java.util.*;
import java.util.stream.Collectors;

public class OrderAnalysis {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>(Arrays.asList(new User(2, "Kirill"),
                new User(1, "Danil"),
                new User(3, "Evelina")));

        List<Product> products1 = new ArrayList<>(Arrays.asList(new Product(1, "PineApple"),
                new Product(2, "Apple"),
                new Product(4, "Батон")));

        List<Product> products2 = new ArrayList<>(Arrays.asList(new Product(1, "Хлеб"),
                new Product(3, "Булка"),
                new Product(4, "Батон"),
                new Product(10, "Pupupu")));

        List<Product> products3 = new ArrayList<>(Arrays.asList(new Product(1, "Корица"),
                new Product(6, "Сахар"),
                new Product(3, "Булка"),
                new Product(4, "Батон")));

        List<Product> products4 = new ArrayList<>(Arrays.asList(new Product(1, "Укроп"),
                new Product(6, "Яблоко"),
                new Product(4, "Батон")));

        ArrayList<Order> orders = new ArrayList<>(Arrays.asList(new Order(1, new User(1, "Danil"), products1),
                new Order(2, new User(2, "Kirill"), products2),
                new Order(3, new User(3, "Evelina"), products3),
                new Order(4, new User(3, "Evelina"), products4)));
        

        Optional<Order> order = orders.stream().sorted(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Integer.compare(o2.getProducts().stream().distinct().toList().size(), o1.getProducts().stream().distinct().toList().size());
            }
        }).findFirst();
        order.ifPresent(o -> System.out.println(o.getUser().getName() + " " + o.getProducts().stream().distinct().toList().size()));

        // Task2
        List lst = orders.stream().flatMap(p -> p.getProducts().stream().map(Product::getName).distinct()).toList();
        lst.stream().filter(p -> Collections.frequency(lst, p) == users.size()).distinct().forEach(System.out::println);

        // Task3
        OptionalDouble res = orders.stream().mapToInt(p -> p.getProducts().size()).average();
        System.out.println(res);

        orders.stream().collect(Collectors.groupingBy(o -> o.getUser().getName(), Collectors.averagingDouble(oo -> oo.getProducts().size()))).forEach((name, avg) -> System.out.println(name + " " + avg));

        // Task4
        int mn = orders.stream().mapToInt(o -> o.getProducts().size()).min().orElse(0);
        orders.stream().filter(p -> p.getProducts().size() == mn).forEach(o -> System.out.println(o.getId() + " " + o.getUser().getName() + " " + o.getProducts()));

        // Task5

        users.forEach(user -> {
            List<String> userProducts = orders.stream().filter(o -> o.getUser().getId() == user.getId()).flatMap(o -> o.getProducts().stream()).map(Product::getName).toList();

            if (!userProducts.isEmpty()) {
                String favorite = userProducts.stream()
                        .max(Comparator.comparingInt(name -> Collections.frequency(userProducts, name)))
                        .get();

                long count = Collections.frequency(userProducts, favorite);

                System.out.println(user.getName() + " чаще всего заказывает: " + favorite + " (" + count + " раза)");
            }
        });

        // Task6

        ArrayList goods = new ArrayList<>(Arrays.asList("Укроп", "Батон"));
        users.forEach(user -> {
            List<String> userProducts = orders.stream().filter(o -> o.getUser().getId() == user.getId()).flatMap(o -> o.getProducts().stream()).map(Product::getName).toList();
            boolean result = goods.stream().allMatch(p -> userProducts.contains(p));
            if (result) System.out.println(user.getName());
        });

    }
}
