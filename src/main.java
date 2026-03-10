import java.util.Scanner;

// Interface for palindrome checking
interface PalindromeAlgorithm {
    boolean isPalindrome(String word);
}

// Algorithm 1: Reverse string method
class ReverseStringAlgorithm implements PalindromeAlgorithm {
    public boolean isPalindrome(String word) {
        String cleaned = word.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
}

// Algorithm 2: Character array comparison
class CharArrayAlgorithm implements PalindromeAlgorithm {
    public boolean isPalindrome(String word) {
        String cleaned = word.replaceAll("\\s+", "").toLowerCase();
        char[] chars = cleaned.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++; end--;
        }
        return true;
    }
}

// PalindromeChecker that chooses algorithm dynamically
class PalindromeChecker {
    private PalindromeAlgorithm algorithm;

    public PalindromeChecker(PalindromeAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public boolean check(String word) {
        return algorithm.isPalindrome(word);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        System.out.println("Choose algorithm: 1 - Reverse, 2 - Char Array");
        int choice = sc.nextInt();

        PalindromeAlgorithm algo;
        if (choice == 1) {
            algo = new ReverseStringAlgorithm();
        } else {
            algo = new CharArrayAlgorithm();
        }

        PalindromeChecker checker = new PalindromeChecker(algo);

        if (checker.check(input)) {
            System.out.println("\"" + input + "\" is a Palindrome");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome");
        }

        sc.close();
    }
}