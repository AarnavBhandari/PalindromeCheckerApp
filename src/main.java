public class Main {

    public static boolean isPalindrome(String word) {
        word = word.replaceAll("\\s+", "").toLowerCase(); // remove spaces and convert to lowercase
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

    public static void main(String[] args) {
        String word = "A man a plan a canal Panama";

        if (isPalindrome(word)) {
            System.out.println("\"" + word + "\" is a Palindrome");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome");
        }
    }
}