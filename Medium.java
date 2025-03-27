import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
    public String getName() {
        return name;
    }
    public double getMarks() {
        return marks;
    }
    public String toString() {
        return name + ": " + marks;
    }
}
public class Medium {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Anshika Goel", 85),
                new Student("Namita Sharma", 72),
                new Student("Hardik", 90),
                new Student("Anubhav", 60),
                new Student("Baronika", 78)
        );
        students.stream()
                .filter(student -> student.getMarks() > 75) 
                .sorted(Comparator.comparingDouble(Student::getMarks)) 
                .forEach(student -> System.out.println(student.getName())); 
    }
}
