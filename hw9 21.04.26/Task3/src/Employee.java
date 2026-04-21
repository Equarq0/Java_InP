import java.util.Objects;

class Employee {
    int id;
    String name;
    int age;
    double salary;
    int departmentId;

    public Employee(int id, String name, int age, double salary, int departmentId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public int getDepartmentId() { return departmentId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && Double.compare(salary, employee.salary) == 0 && departmentId == employee.departmentId && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary, departmentId);
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}