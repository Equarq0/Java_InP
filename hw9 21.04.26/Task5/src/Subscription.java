import java.util.Objects;

class Subscription {
    int id;
    String serviceName;
    double monthlyCost;
    boolean isPremium;

    public Subscription(int id, String serviceName, double monthlyCost, boolean isPremium) {
        this.id = id;
        this.serviceName = serviceName;
        this.monthlyCost = monthlyCost;
        this.isPremium = isPremium;
    }

    public int getId() { return id; }
    public String getServiceName() { return serviceName; }
    public boolean isPremium() { return isPremium; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return id == that.id && isPremium == that.isPremium && Double.compare(monthlyCost, that.monthlyCost) == 0 && Objects.equals(serviceName, that.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceName, monthlyCost, isPremium);
    }

    @Override
    public String toString() {
        return "Subscription{service='" + serviceName + "', premium=" + isPremium + "}";
    }
}