import java.util.Scanner;

// Interface for palindrome checking
interface PalindromeAlgorithm {
    boolean isPalindrome(String word);
}

// Algorithm 1: Reverse string
class ReverseStringAlgorithm implements PalindromeAlgorithm {
    public boolean isPalindrome(String word) {
        String cleaned = word.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
}

// Algorithm 2: Character array
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

// Algorithm 3: Recursion
class RecursionAlgorithm implements PalindromeAlgorithm {
    private boolean helper(String word, int start, int end) {
        if (start >= end) return true;
        if (word.charAt(start) != word.charAt(end)) return false;
        return helper(word, start + 1, end - 1);
    }
    public boolean isPalindrome(String word) {
        String cleaned = word.replaceAll("\\s+", "").toLowerCase();
        return helper(cleaned, 0, cleaned.length() - 1);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to test performance:");
        String input = sc.nextLine();
        sc.close();

        PalindromeAlgorithm[] algorithms = {
                new ReverseStringAlgorithm(),
                new CharArrayAlgorithm(),
                new RecursionAlgorithm()
        };

        String[] names = {
                "Reverse String",
                "Character Array",
                "Recursion"
        };

        for (int i = 0; i < algorithms.length; i++) {
            long startTime = System.nanoTime();
            boolean result = algorithms[i].isPalindrome(input);
            long endTime = System.nanoTime();
            System.out.println(names[i] + ": " + (result ? "Palindrome" : "Not Palindrome")
                    + " | Time: " + (endTime - startTime) + " ns");
        }
    }
}