import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + ", " + age + ", " + salary;
    }
}
public class Easy {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Anshika", 21, 50000));
        employees.add(new Employee("Ananya", 20, 55000));
        employees.add(new Employee("Vivek", 35, 60000));
        employees.add(new Employee("Namita", 28, 45000));

        Collections.sort(employees, (e1, e2) -> e1.name.compareTo(e2.name));
        System.out.println("Sorted by name: " + employees);

        Collections.sort(employees, (e1, e2) -> Integer.compare(e1.age, e2.age));
        System.out.println("Sorted by age: " + employees);

        Collections.sort(employees, (e1, e2) -> Double.compare(e1.salary, e2.salary));
        System.out.println("Sorted by salary: " + employees);
    }
}

