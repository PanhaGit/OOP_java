package OOP;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int[][] a = new int[3][3];
        Scanner sc = new Scanner(System.in);

        System.out.println("Input Number 9 matrix :");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j]);
                if (j < 2)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
