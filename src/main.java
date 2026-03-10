import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {

        String word = "level";

        Deque<Character> deque = new ArrayDeque<>();

        // Add all characters to deque
        for (char ch : word.toCharArray()) {
            deque.addLast(ch);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();
            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }

    }
}