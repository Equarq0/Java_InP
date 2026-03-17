import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 10; i <= 70; i += 10) {
            students.add(new Student("name" + i / 10, i, i / 5));
        }

        for (Student student : students) {
            System.out.println(student);
        }
        Collections.sort(students);
        System.out.println(students);

        Comparator<Student> namesComparator =  new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        students.sort(namesComparator);
        System.out.println(students);

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student student = it.next();
            if (student.getMissedClasses() > 5) it.remove();
        }
        System.out.println(students);
    }
}