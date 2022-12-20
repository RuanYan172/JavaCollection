import program.StudentProgram;
import program.SubjectProgram;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final SubjectProgram subjectProgram = SubjectProgram.INTANCE;
    private static final StudentProgram studentProgram = StudentProgram.INTANCE;
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        while (true) {
            System.out.println("\t\t 1. Quan ly mon hoc : ");
            System.out.println("\t\t 2. Quan ly hoc sinh : ");
            System.out.println("\t\t 3. Quan ly giao vien : ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> subjectProgram.runProgram();

                case 2 -> studentProgram.runProgram();


                case 3 -> {
                }
            }
        }
    }
}