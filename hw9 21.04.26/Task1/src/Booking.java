import java.time.LocalDate;
import java.util.Objects;

public class Booking extends Entity<Integer> {
    Client client;
    Room room;
    LocalDate checkInDate;
    LocalDate checkOutDate;

    public Booking(int id, Client client, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.client = client;
        this.room = room;
        this.checkOutDate = checkOutDate;
        this.checkInDate = checkInDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "client=" + client +
                ", room=" + room +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }

    public int hashCode() {
        return Objects.hash(client, room, checkInDate, checkOutDate);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(client, booking.client) && Objects.equals(room, booking.room)
                && Objects.equals(checkInDate, booking.checkInDate) && Objects.equals(checkOutDate, booking.checkOutDate);
    }
}
