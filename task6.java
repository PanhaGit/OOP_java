import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = -1;

        while (number != 0) {
            System.out.print("Enter a number (0 to stop): ");
            number = scanner.nextInt();

            if (number != 0) {
                System.out.println("You entered: " + number);
            }
        }

        System.out.println("Program ended.");
        scanner.close();
    }
}
