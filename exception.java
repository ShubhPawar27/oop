import java.util.Scanner;

public class exception{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get input from user
            System.out.print("Enter the first number (Num1): ");
            String input1 = scanner.nextLine();
            System.out.print("Enter the second number (Num2): ");
            String input2 = scanner.nextLine();

            // Parse inputs to integers
            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);

            // Perform division
            int result = num1 / num2;
            System.out.println("The result of the division is: " + result);

        } catch (NumberFormatException e) {
            // Handle case where inputs are not integers
            System.out.println("Error: Invalid input. Please enter valid integers.");
        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            // Always close the scanner
            scanner.close();
            System.out.println("Program execution completed.");
        }
    }
}

