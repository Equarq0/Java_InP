import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Аня", 19, "Java", 4.5, List.of("Теннис", "Кино")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")),
                new Student("Борис", 19, "Java", 4.9, List.of("Кино", "Чтение")),
                new Student("Света", 21, "C++", 4.0, List.of("Музыка", "Игры")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")));

        students.stream()
                .skip(1)
                .limit(3)
                .filter(student -> student.getAge() > 19)
                .map(Student::getName)
                .forEach(System.out::println);

        long count = students.stream()
                .filter(student -> student.getAge() > 19)
                .count();

        System.out.println(count);

        students.stream()
                .map(Student::getLanguage)
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        boolean java = students.stream().anyMatch(student -> student.getLanguage().equals("Java"));
        boolean age18plus = students.stream().allMatch(student -> student.getAge() > 17);
        boolean rating = students.stream().allMatch(student -> student.getRating() > 3.0);
        // Set<List<String>> hob = students.stream().map(Student::getHobbies).collect(Collectors.toSet());
        // System.out.println(hob);
        Set<String> hobbies = students.stream().flatMap(student -> student.getHobbies().stream()).collect(Collectors.toSet());
        System.out.println(hobbies);

        Map<String, List<Student>> mapByLanguage = students.stream().collect(Collectors.groupingBy(Student::getLanguage));
        String st = students.stream().filter(student -> student.getRating() > 4.0).map(Student::getName).collect(Collectors.joining(", ", "Отличники: ", "!"));
        System.out.println(st);

        Optional<Student> perfect = students.stream().filter(student -> student.getRating() == 5.0).findFirst();
        perfect.ifPresentOrElse(student -> System.out.println(student.getName()), () -> System.out.println("Нет такого"));




    }
}