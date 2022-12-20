package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private final List<Subject> subjects = new ArrayList<>();
    ;

    public Student(String name, int age) {
        super(name, age);
    }

    public Student(Student student){
        this.setId(student.getId());
        this.setName(student.getName());
        this.setAge(student.getAge());
    }

    public Student(int id) {
        this.setId(id);
        this.setAge(-1);
    }

    public void submitSubject(List<Subject> subjects) {
        this.subjects.clear();
        this.subjects.addAll(subjects);
    }
}
