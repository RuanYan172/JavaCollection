package service;

import model.Student;
import model.Subject;

import java.util.ArrayList;
import java.util.List;

public class StudentsService implements BasicOperator<Student> {
    public static StudentsService INTANCE = new StudentsService();
    private List<Student> studentList;

    private StudentsService() {
        studentList = new ArrayList<>();
    }

    @Override
    public List<Student> getAllData() {
        return studentList;
    }

    @Override
    public Student getDataById(int id) {

        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student addData(Student data) throws Exception {
        if (getDataById(data.getId()) == null) {
            studentList.add(data);
            return data;
        }

        throw new Exception("Hoc sinh da ton tai");
    }

    @Override
    public Student updateData(Student data) {
        Student student = getDataById(data.getId());
        if (student == null) return null;
        boolean validationName = data.getName() != null && !data.getName().isBlank();
        boolean validationAge = data.getAge() > 0;
        String name = data.getName();
        int age = data.getAge();
        if (validationName) student.setName(name);
        if (validationAge) student.setAge(age);
        return student;
    }

    @Override
    public Student removeDataById(int id) {
        Student student = getDataById(id);
        if (student == null) return null;
        this.studentList.remove(student);
        return student;
    }
}



