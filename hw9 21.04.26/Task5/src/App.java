import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Subscription> subscriptions = DataGenerator_Task5.generateSubscriptions();
        List<User> users = DataGenerator_Task5.generateUsers();

        Map<Integer, Subscription> subMap = subscriptions.stream()
                .collect(Collectors.toMap(Subscription::getId, s -> s));

        // Task 1
        System.out.println("Task1");
        users.stream()
                .map(u -> {
                    Subscription s = subMap.get(u.getSubscriptionId());
                    return String.format("Пользователь: %s, Возраст: %d, Сервис: %s, Премиум: %s, Часов в месяц: %d",
                            u.getName(), u.getAge(), s.getServiceName(), s.isPremium() ? "да" : "нет", u.getWatchHoursPerMonth());
                })
                .forEach(System.out::println);

        // Task 2
        System.out.println("\nTask2");
        Map<String, Integer> hoursByService = users.stream()
                .collect(Collectors.groupingBy(
                        u -> subMap.get(u.getSubscriptionId()).getServiceName(),
                        Collectors.summingInt(User::getWatchHoursPerMonth)
                ));
        System.out.println(hoursByService);

        // Task 3
        System.out.println("\nTask3");
        users.stream()
                .filter(u -> u.getAge() < 30)
                .sorted(Comparator.comparingInt(User::getWatchHoursPerMonth).reversed())
                .limit(3)
                .forEach(System.out::println);

        // Task 4
        System.out.println("\nTask4");
        User minWatcher = Collections.min(users, Comparator.comparingInt(User::getWatchHoursPerMonth));
        System.out.println(minWatcher);

        // Task 5
        System.out.println("\nTask5");
        Map<String, Boolean> userToPremium = users.stream()
                .collect(Collectors.toMap(
                        User::getName,
                        u -> subMap.get(u.getSubscriptionId()).isPremium(),
                        (existing, replacement) -> existing
                ));
        System.out.println(userToPremium);

        // Task 6
        System.out.println("\nTask6");
        List<String> allGenres = users.stream()
                .flatMap(u -> u.getGenres().stream())
                .collect(Collectors.toList());

        System.out.println("Все просмотренные жанры: " + allGenres);
    }
}