public class Student implements Comparable<Student> {
    String name;
    double rating;
    int missedClasses;

    public Student(String name, double rating, int missedClasses) {
        this.name = name;
        this.rating = rating;
        this.missedClasses = missedClasses;
    }

    public String getName() {
        return this.name;
    }

    public double getRating() {
        return this.rating;
    }

    public int getMissedClasses() {
        return this.missedClasses;
    }

    @Override
    public String toString() {
        return "name: " + name + "; rating: " + rating + "; missedClasses: " + missedClasses;
    }


    @Override
    public int compareTo(Student o) {
        return Double.compare(o.rating, this.rating);
    }
}
