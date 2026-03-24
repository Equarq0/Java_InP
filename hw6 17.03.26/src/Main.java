import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 10; i <= 70; i += 10) {
            students.add(new Student("name" + i / 10, i, i / 5));
        }
        students.add(new Student("Коля", 50, 10));
        students.add(new Student("Толя", 340, 200));
        students.add(new Student("Аля", 0, 1000));
        students.add(new Student("Сanya", 300, 2));

        for (Student student : students) {
            System.out.println(student);
        }
        Collections.sort(students);
        System.out.println(students);


    }
}