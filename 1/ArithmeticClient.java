import java.rmi.Naming;
import java.util.Scanner;

public class ArithmeticClient {
    public static void main(String[] args) {
        try {
            ArithmeticService service = (ArithmeticService) Naming.lookup(
                "rmi://localhost/ArithmeticService"
            );

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            System.out.println("\nChoose operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            double result = 0;

            switch (choice) {
                case 1: result = service.add(num1, num2); break;
                case 2: result = service.subtract(num1, num2); break;
                case 3: result = service.multiply(num1, num2); break;
                case 4: result = service.divide(num1, num2); break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }

            System.out.println("Result: " + result);
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/*
 Terminal_1->(1) javac *.java
	     (2)java ArithmeticServer
 Terminal_2->(1)java ArithmeticClient
*/