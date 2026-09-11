import java.util.Scanner;

class Operations {
    void calculate(int a, int b) {
        System.out.println("Addition = " + (a + b));
        System.out.println("Subtraction = " + (a - b));
        System.out.println("Multiplication = " + (a * b));

        if (b != 0)
            System.out.println("Division = " + ((double) a / b));
        else
            System.out.println("Division is not possible by zero");
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        Operations op = new Operations();
        op.calculate(a, b);

        sc.close();
    }
}