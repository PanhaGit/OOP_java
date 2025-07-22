import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float score;

        System.out.print("INPUT SCORE: ");
        score = scanner.nextFloat();

        if (score >= 90) {
            System.out.println("EXCELLENT");
        } else if (score >= 70 && score < 89) {
            System.out.println("GOOD");
        } else if (score >= 50 && score < 69) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
