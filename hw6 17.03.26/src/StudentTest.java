import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StudentTest {
    private List<Student> students;

    @BeforeEach
    void setUp() {
        students = new ArrayList<>();
        Random random = new Random(42);
        for (int i = 0; i < 100; i++) {
            students.add(new Student(random.nextInt(100) + "student", random.nextInt(1, 100), random.nextInt(1, 50)));
        }
    }
    @Test
    void testJustCheck() {
        System.out.println(students);
    }

    @Test
    void testComparable() {
        Collections.sort(students);
        int first = (students.get(0).getMissedClasses());
        for (Student student: students) {
            Assertions.assertTrue(student.getMissedClasses() >= first);
        }

        for (int i = 0; i < 99; i++) {
            Student current = students.get(i);
            Student next = students.get(i + 1);
            if (current.getMissedClasses() == next.getMissedClasses()) {
                Assertions.assertTrue(current.getRating() >= next.getRating());
            }
        }
    }

    @Test
    void testUtilityComparator() {
        Comparator<Student> scoreComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                double sc1 = (s1.getRating() * 0.7) - (s1.getMissedClasses() * 0.1);
                double sc2 = (s2.getRating() * 0.7) - (s2.getMissedClasses() * 0.1);
                return Double.compare(sc2, sc1);
            }
        };

        Collections.sort(students, scoreComparator);

        for (int i = 0; i < students.size() - 1; i++) {
            double s1 = (students.get(i).getRating() * 0.7) - (students.get(i).getMissedClasses() * 0.1);
            double s2 = (students.get(i + 1).getRating() * 0.7) - (students.get(i + 1).getMissedClasses() * 0.1);
            Assertions.assertTrue(s1 >= s2);
        }
    }

    @Test
    void testIteratorLogic() {
        int startLenght = students.size();
        Iterator iterator = students.iterator();
        int deletedCount = 0;
        ArrayList<Student> badStudents = new ArrayList<>();
        while (iterator.hasNext()) {
            Student student = (Student) (iterator.next());
            if (student.rating < 2.0) {
                if (student.missedClasses > 15) {
                    iterator.remove();
                }
                else {
                    badStudents.add(student);
                    iterator.remove();
                }
                deletedCount++;
            }
        }
        for (Student student: students) {
            Assertions.assertTrue(student.getRating() > 2.0);
        }
        Assertions.assertEquals(students.size(), startLenght - deletedCount);

        for (Student student: badStudents) {
            Assertions.assertTrue(student.rating < 2.0);
            Assertions.assertTrue(student.missedClasses <= 15);
        }
    }
}
