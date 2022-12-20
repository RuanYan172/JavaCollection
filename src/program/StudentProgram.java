package program;

import model.Student;
import model.Subject;
import service.StudentsService;
import service.SubjectsService;

import java.util.Scanner;

public class StudentProgram {
    private static Scanner sc = new Scanner(System.in);
    public static StudentProgram INTANCE = new StudentProgram();
    private static StudentsService studentsService = StudentsService.INTANCE;

    private StudentProgram() {

    }

    public void runProgram() {
        while (true) {
            System.out.println("\t\t 1. Them hoc sinh : ");
            System.out.println("\t\t 2. Sua hoc sinh : ");
            System.out.println("\t\t 3. Xoa hoc sinh : ");
            System.out.println("\t\t 4. Hien thi tat ca hoc sinh : ");
            System.out.println("\t\t 5. Quay lai : ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> addStudentFromKeyBoard();

                case 2 -> editStudentFromKeyBoard();

                case 3 -> removeStudentFromKeyBoard();

                case 4 -> printScreenAllStudent();

                case 5 -> {
                    return;
                }


            }
        }
    }

    public void addStudentFromKeyBoard() {
        System.out.println("Nhap ten hoc sinh");
        String name = sc.nextLine();
        System.out.println("Nhap tuoi");
        int age = sc.nextInt();
        sc.nextLine();
        Student student = new Student(name, age);
        try {
            studentsService.addData(student);
        } catch (Exception e) {
            System.out.println("Id da ton tai");
        }

    }

    private void editStudentFromKeyBoard() {
        System.out.println("Nhap id hoc sinh : ");
        int id = sc.nextInt();
        sc.nextLine();
        Student studentReal = studentsService.getDataById(id);
        if (studentReal == null) return;
        Student student = new Student(studentReal);
        while (true) {
            System.out.println("\t\t 1. sua ten hoc sinh : ");
            System.out.println("\t\t 2. sua tuoi hoc sinh : ");
            System.out.println("\t\t 3. chap nhan thay doi hoc sinh : ");
            System.out.println("\t\t 4. quay lai : ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> {
                    System.out.println("\t\t 1. Nhap ten hoc sinh : ");
                    String name = sc.nextLine();
                    student.setName(name);
                }
                case 2 -> {
                    System.out.println("\t\t 1. Nhap tuoi hoc sinh : ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    student.setAge(age);
                }
                case 3 -> {
                    studentsService.updateData(student);
                    System.out.println("Da thay doi thanh cong");
                    return;
                }
                case 4 -> {
                    return;
                }
            }
            System.out.println("\t\t hoc sinh da thay doi:");

            System.out.println(student);
        }
    }

    private void removeStudentFromKeyBoard() {
        System.out.println("Nhap id cua hoc sinh");
        int id = sc.nextInt();
        sc.nextLine();
        studentsService.removeDataById(id);
    }

    public void printScreenAllStudent() {
        studentsService.getAllData().forEach(item -> System.out.println(item.toString()));
    }
}
