import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String word = "racecar";

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (char ch : word.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters and build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // Check palindrome
        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }

    }
}