package program;

import model.Subject;
import service.SubjectsService;

import java.util.Scanner;

public class SubjectProgram {
    private static Scanner sc = new Scanner(System.in);
    public static SubjectProgram INTANCE = new SubjectProgram();
    private static SubjectsService subjectsService = SubjectsService.INTANCE;

    private SubjectProgram() {

    }

    public void runProgram() {

        while (true) {
            System.out.println("\t\t 1. Them mon hoc : ");
            System.out.println("\t\t 2. Sua mon hoc : ");
            System.out.println("\t\t 3. Xoa mon hoc : ");
            System.out.println("\t\t 4. Hien thi tat ca mon hoc : ");
            System.out.println("\t\t 5. Quay lai : ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> addSubjectFromKeyboard();

                case 2 -> editSubjectFromKeyBoard();

                case 3 -> removeSubjectFromKeyBoard();

                case 4 -> printScreenAllSubject();

                case 5 -> {
                    return;
                }
            }
        }
    }

    private void addSubjectFromKeyboard() {
        System.out.println("Nhap ten mon hoc :");
        String name = sc.nextLine();
        System.out.println("Nhap so nguoi dang ky toi da:");
        int maxNumber = sc.nextInt();
        sc.nextLine();
        Subject subject = new Subject(name, maxNumber);
        try {
            subjectsService.addData(subject);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void editSubjectFromKeyBoard() {
        System.out.println("Nhap id mon hoc ban muon sua : ");
        int id = sc.nextInt();
        sc.nextLine();
        Subject subject = new Subject(id);
        while (true) {
            System.out.println("\t\t 1. sua ten mon hoc : ");
            System.out.println("\t\t 2. sua so nguoi hien tai tham gia mon hoc : ");
            System.out.println("\t\t 3. sua so nguoi toi da tham gia mon hoc : ");
            System.out.println("\t\t 4. chap nhan thay doi mon hoc : ");
            System.out.println("\t\t 5. quay lai : ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> {
                    System.out.println("\t\t 1. Nhap ten mon hoc : ");
                    String name = sc.nextLine();
                    subject.setName(name);
                }
                case 2 -> {
                    System.out.println("\t\t 1. Nhap so nguoi hien tai dang tham gia mon hoc : ");
                    int currentNumber = sc.nextInt();
                    subject.setCurrentNumber(currentNumber);
                }
                case 3 -> {
                    System.out.println("\t\t 1. Nhap so nguoi toi da  tham gia mon hoc : ");
                    int maxNumber = sc.nextInt();
                    sc.nextLine();
                    subject.setMaxNumber(maxNumber);
                }
                case 4 -> {
                    subjectsService.updateData(subject);
                    System.out.println("Da thay doi thanh cong");
                    return;
                }
                case 5 -> {
                    return;
                }
            }
            System.out.println("\t\t mon hoc da thay doi:");
            System.out.println(subject);
        }
    }

    private void removeSubjectFromKeyBoard() {
        System.out.println("Nhap Id mon hoc ban muon xoa :");
        int id = sc.nextInt();
        sc.nextLine();
        subjectsService.removeDataById(id);
    }

    private void printScreenAllSubject() {
        subjectsService.getAllData().forEach(item -> System.out.println(item.toString()));
    }
}
