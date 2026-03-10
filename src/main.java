public class Main {

    public static void main(String[] args) {

        String word = "madam";

        StringBuilder reverse = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse.append(word.charAt(i));
        }

        if (word.equals(reverse.toString())) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }

    }
}