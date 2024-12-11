import java.util.*;
import java.util.function.Predicate;

public class generic {

    // Generic method to count elements based on a specific property
    public static <T> int countByProperty(Collection<T> collection, Predicate<T> property) {
        int count = 0;
        for (T element : collection) {
            if (property.test(element)) {
                count++;
            }
        }
        return count;
    }

    // Helper method to check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Helper method to check if a number is a palindrome
    private static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        // Create a collection of integers
        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 121, 101, 37, 13, 17, 19, 23);

        // Count even numbers
        int evenCount = countByProperty(numbers, n -> n % 2 == 0);
        System.out.println("Count of even numbers: " + evenCount);

        // Count odd numbers
        int oddCount = countByProperty(numbers, n -> n % 2 != 0);
        System.out.println("Count of odd numbers: " + oddCount);

        // Count prime numbers
        int primeCount = countByProperty(numbers, generic::isPrime);
        System.out.println("Count of prime numbers: " + primeCount);

        // Count palindromes
        int palindromeCount = countByProperty(numbers, generic::isPalindrome);
        System.out.println("Count of palindrome numbers: " + palindromeCount);
    }
}
