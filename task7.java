import java.util.Scanner;

public class task7 {

    public static void calculateLoad(double p, int r, double y) {
        double m_r = (double) r / (12 * 100);
        int m = (int) (y * 12);

        System.out.printf("Loan Amount: $%.2f\n", p);
        System.out.printf("Monthly Interest Rate: %.5f\n", m_r);
        System.out.printf("Loan Term : %d\n", m);

        double m_p = (p * m_r)
                / (1 - Math.pow(1 + m_r, -m));

        System.out.printf("Monthly Payment: $%.2f\n", m_p);

        double t_p = m_p * m;
        System.out.printf("Total Payment: $%.2f\n\n", t_p);

        System.out.printf("%-10s%-12s%-12s%-12s\n", "Payment#", "Interest", "principal", "Balance");

        double balance = p;

        for (int i = 1; i <= m; i++) {
            if (i % 12 == 1) {
                System.out.printf("---------------- Start of Year %d ----------------\n", (i / 12) + 1);
            }
            double interest = balance * m_r;
            double p_pay = m_p - interest;

            if (p_pay > balance) {
                p_pay = balance;
                m_p = interest + p_pay;
            }

            balance -= p_pay;

            System.out.printf("%-10d%-12.2f%-12.2f%-12.2f\n", i, interest, p_pay, balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double p, y;
        int r;

        System.out.print("Enter Price amount: ");
        p = sc.nextDouble();

        System.out.print("Enter rate: ");
        r = sc.nextInt();

        System.out.print("Enter y: ");
        y = sc.nextDouble();

        calculateLoad(p, r, y);
    }
}
