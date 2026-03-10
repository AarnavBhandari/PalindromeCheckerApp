public class Main {

    public static void main(String[] args) {
        String word = "A man a plan a canal Panama";

        // Use PalindromeChecker class
        PalindromeChecker checker = new PalindromeChecker();
        if (checker.isPalindrome(word)) {
            System.out.println("\"" + word + "\" is a Palindrome");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome");
        }
    }
}

// Encapsulated palindrome logic
class PalindromeChecker {

    public boolean isPalindrome(String word) {
        if (word == null) return false;

        word = word.replaceAll("\\s+", "").toLowerCase(); // ignore spaces and case
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}