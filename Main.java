import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String student_name;
        int age;
        double gpa;
        char gender;
        boolean passed;

        System.out.println("====================== INFO ======================");
        System.out.print("INPUT STUDENT NAME: ");
        student_name = scanner.nextLine();

        System.out.print("INPUT AGE : ");
        age = scanner.nextInt();

        System.out.print("INPUT GENDER(M - F): ");
        gender = scanner.next().charAt(0);

        System.out.print("INPUT GPA : ");
        gpa = scanner.nextDouble();

        System.out.print("INPUT PASSED (true - false): ");
        passed = scanner.nextBoolean();

        System.out.println("======================= OUTPUT INFO======================");

        System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "NAME", "AGE", "GPA", "GENDER", "PASSED");
        System.out.printf("%-10s%-10d%-10.2f%-10c%-10b", student_name, age, gpa, gender, passed);
    }
}
