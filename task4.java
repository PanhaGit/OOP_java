import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days;

        System.out.print("INPUT DAYS (0 - 6): ");
        days = scanner.nextInt();

        switch (days) {
            case 0:
                System.out.println("SUNDAY");
                break;
            case 1:
                System.out.println("MONDAY");
                break;
            case 2:
                System.out.println("TUESDAY");
                break;
            case 3:
                System.out.println("WEDNESDAY");
                break;
            case 4:
                System.out.println("THURSDAY");
                break;
            case 5:
                System.out.println("FRIDAY");
                break;
            case 6:
                System.out.println("SATURDAY");
                break;
            default:
                break;
        }
    }
}
