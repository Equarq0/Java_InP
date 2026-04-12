import java.time.LocalDateTime;
import java.util.List;

public class Order implements Comparable<Order> {
    private int id;
    private User user;
    private List<Product> products;
    private LocalDateTime orderDate;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                ", orderDate=" + orderDate +
                '}';
    }

    public Order(int id, User user, List<Product> products, LocalDateTime orderDate) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.orderDate = orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDateTime getOrderDate() { return  orderDate; }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(other.products.size(), this.products.size());
    }
}
