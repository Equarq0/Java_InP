import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Department> departmentList = DataGenerator_Task3.generateDepartments();
        List<Employee> employeeList = DataGenerator_Task3.generateEmployees();

        Map<Integer, Department> depMap = departmentList.stream()
                .collect(Collectors.toMap(Department::getId, d -> d));

        // Task 1
        System.out.println("Task1");
        employeeList.stream()
                .map(e -> String.format("%s (возраст %d) работает в отделе %s, получает %.2f₽",
                        e.getName(), e.getAge(), depMap.get(e.getDepartmentId()).getName(), e.getSalary()))
                .forEach(System.out::println);

        // Task 2
        System.out.println("\nTask2");
        Map<String, Double> salaryByDep = employeeList.stream()
                .collect(Collectors.groupingBy(
                        e -> depMap.get(e.getDepartmentId()).getName(),
                        Collectors.summingDouble(Employee::getSalary)
                ));
        System.out.println(salaryByDep);

        // Task 3
        System.out.println("\nTask3");
        employeeList.stream()
                .filter(e -> e.getAge() < 35)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        // Task 4
        System.out.println("\nTask4");
        Employee richest = Collections.max(employeeList, Comparator.comparingDouble(Employee::getSalary));
        System.out.println(richest);

        // Task 5
        System.out.println("\nTask5");
        Map<Integer, String> employeeToDepName = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        e -> depMap.get(e.getDepartmentId()).getName()
                ));
        System.out.println(employeeToDepName);

        // Task 6
        System.out.println("\nTask6");
        Map<Department, List<Employee>> employeesByDep = employeeList.stream()
                .collect(Collectors.groupingBy(e -> depMap.get(e.getDepartmentId())));

        List<String> allNames = employeesByDep.values().stream()
                .flatMap(Collection::stream)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(employeesByDep);
        System.out.println(allNames);
    }
}