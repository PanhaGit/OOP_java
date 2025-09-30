package hw;

import java.util.Scanner;

public class fn4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================ Student ID Generator ================");
        System.out.print("Enter starting number: ");
        int start = sc.nextInt();

        System.out.print("How many IDs to generate? ");
        int count = sc.nextInt();

        System.out.println("Generated Student IDs:");
        for (int i = 0; i < count; i++) {
            int idNumber = start + i;
            String studentId = String.format("%07d", idNumber);
            System.out.println(studentId);
        }
    }
}
