import java.util.List;

public class Order implements Comparable<Order> {
    private int id;
    private User user;
    private List<Product> products;

    public Order(int id, User user, List<Product> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
    public User getUser() { return user; }
    public int getId() { return id; }
    @Override
    public String toString() {
        return "products = " + products;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(other.products.size(), this.products.size());
    }
}
