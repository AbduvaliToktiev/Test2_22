package functional_programming.lambda.mapReduce;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int age;
    private String name;
    private final List<Integer> marks = new ArrayList<>();

    public Student() {

    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Age = " + age + " | Name = " + name;
    }
}
