import java.util.InputMismatchException;
import java.util.Scanner;

class CalcTeylor {
    public static void calculation() {
        double x, eps = 1, a = 1, sum = 0;
        int i, k;
        try {
            System.out.println("Enter x, k (x - real, k - integer):");
            x = inputX();
            k = inputK();
            if ((x <= -0.999) || (x >= 0.999))
                throw new ArithmeticException();
            else if ((k > 300) || (k < 1))
                throw new ArithmeticException();
            else {
                a = 1;
                double tmpX = x;
                for (i = 1; i <= k; i++)
                    eps /= 10;
                i = 1;
                while ((Math.abs((i * (i + 1) / 2) * a)) >= eps) {
                    sum = sum + (i * (i + 1) / 2) * a;
                    a = a * (-x);
                    i++;
                }
                double standartCalculation = 1 / ((1 + x) * (1 + x) * (1 + x));
                System.out.format("Calculations by Teylor: %.3f \n", sum);
                System.out.format("Standart calculations: %.3f \n", standartCalculation);
            }
        } catch (NumberFormatException e) {
            System.out.println("One of the numbers is uncorrect(uncorrect input)!");
        } catch (ArithmeticException e) {
            System.out.println("One of the numbers doesn't meet the conditions!");
        } catch (InputMismatchException e) {
            System.out.println("Input/output error!");
        }
    }

    private static double inputX() throws InputMismatchException {
        double tmpX;
        Scanner sc = new Scanner(System.in);
        System.out.println("(-0.999 <= x <= 0.999)");
        System.out.println("x =");
        tmpX = sc.nextDouble();
        return tmpX;
    }

    private static int inputK() throws InputMismatchException {
        int tmpK;
        Scanner sc = new Scanner(System.in);
        System.out.println("(0 < k < 300)");
        System.out.println("k =");
        tmpK = sc.nextInt();
        return tmpK;
    }
}
