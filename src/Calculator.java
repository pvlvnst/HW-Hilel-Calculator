import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public float calculate(float x, float y, String operation) {
        return switch (operation) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println("Calculator by Anastasia \uD83D\uDE43\t");
        while (true) {
            try {
                Calculator calc = new Calculator();

                Scanner sc = new Scanner(System.in);

                System.out.print("Input type of the operation: ");
                String operation = sc.nextLine();

                if (
                        !operation.equals("+") &&
                                !operation.equals("-") &&
                                !operation.equals("*") &&
                                !operation.equals("/")
                ) {
                    System.out.println("Operation can only be one of those [+, -, *, /]");
                    continue;
                }

                System.out.print("Input your 1st number: ");
                float x = sc.nextFloat();
                System.out.print("Input your 2nd number: ");
                float y = sc.nextFloat();

                // If division, cannot divide by zero
                if (operation.equals("/") && y == 0.0) {
                    System.out.println("Cannot divide by zero");
                    continue;
                }
                System.out.println("Your result is: " + calc.calculate(x, y, operation));

            } catch (InputMismatchException e) {
                System.out.println("Please, input a real number, you twat");
            }
        }
    }
}
