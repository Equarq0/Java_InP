import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Client> clientList = DataGenerator_Task1.generateClients();
        List<Room> roomList = DataGenerator_Task1.generateRooms();
        List<Booking> bookingList = DataGenerator_Task1.generateBookings(clientList, roomList);
        for (Booking booking: bookingList) {
            System.out.println(booking);
        }
    }
}