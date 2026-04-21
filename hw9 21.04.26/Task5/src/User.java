import java.util.Objects;

class User {
    int id;
    String name;
    int age;
    int subscriptionId;
    int watchHoursPerMonth;
    java.util.List<String> genres; // Для задания 6

    public User(int id, String name, int age, int subscriptionId, int watchHoursPerMonth, java.util.List<String> genres) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subscriptionId = subscriptionId;
        this.watchHoursPerMonth = watchHoursPerMonth;
        this.genres = genres;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getSubscriptionId() { return subscriptionId; }
    public int getWatchHoursPerMonth() { return watchHoursPerMonth; }
    public java.util.List<String> getGenres() { return genres; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && subscriptionId == user.subscriptionId && watchHoursPerMonth == user.watchHoursPerMonth && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, subscriptionId, watchHoursPerMonth);
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', hours=" + watchHoursPerMonth + "}";
    }
}