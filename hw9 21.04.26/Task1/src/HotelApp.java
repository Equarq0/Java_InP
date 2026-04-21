import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class HotelApp {
    public static void main(String[] args) {
        List<Client> clientList = DataGenerator_Task1.generateClients();
        List<Room> roomList = DataGenerator_Task1.generateRooms();
        List<Booking> bookingList = DataGenerator_Task1.generateBookings(clientList, roomList);

        // Task1
        System.out.println("Task1");
        bookingList.forEach(p -> System.out.println("Клиент: " + p.getClient().getName()
                + ", Номер: " + p.getRoom().getRoomNumber() + ", Заезд: " + p.getCheckInDate() + ", Выезд: " + p.getCheckOutDate()));

        // Task2
        System.out.println("Task2");
        Map<String, Double> m = bookingList.stream().collect(Collectors.groupingBy(p -> p.getRoom().getRoomNumber(), Collectors.summingDouble(b -> ChronoUnit.DAYS.between(b.getCheckInDate(), b.getCheckOutDate()) * b.getRoom().getPricePerNight())));
        System.out.println(m);
        // Task3
        System.out.println("Task3");
        bookingList.stream().sorted((o1, o2) -> Double.compare(o2.getRoom().getPricePerNight(), o1.getRoom().getPricePerNight())).distinct().limit(3).forEach(p -> System.out.println(p.getRoom()));

        // Task4
        System.out.println("Task4");
        Map<Client, Double> myMap = bookingList.stream().collect(Collectors.groupingBy(c -> c.getClient(), Collectors.summingDouble(x -> ChronoUnit.DAYS.between(x.getCheckInDate(), x.getCheckOutDate()))));
        Client vip = Collections.max(myMap.keySet(), (o1, o2) -> {
            Double sum1 = myMap.get(o1);
            Double sum2 = myMap.get(o2);
            return Double.compare(sum1, sum2);
        });
        System.out.println(vip);

        // Task5
        System.out.println("Task5");
        Map<String, Double> roomPrices = roomList.stream().collect(Collectors.toMap(r -> r.roomNumber, r -> r.pricePerNight));
        System.out.println(roomPrices);

         // Task6
        System.out.println("Task6");
        Map<Client, List<Booking>> clientBookingsMap = bookingList.stream()
                .collect(Collectors.groupingBy(Booking::getClient));

        List<LocalDate> allCheckInDates = clientBookingsMap.values().stream()
                .flatMap(Collection::stream)
                .map(Booking::getCheckInDate)
                .collect(Collectors.toList());

        System.out.println(clientBookingsMap);
        System.out.println(allCheckInDates);
    }
}
