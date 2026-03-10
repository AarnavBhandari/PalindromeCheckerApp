class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    // Function to check palindrome
    public static boolean isPalindrome(Node head) {
        Node slow = head, fast = head;
        Node prev = null, temp;

        // Reverse first half while finding middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            // Reverse current node
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // If odd number of elements, skip middle
        if (fast != null) {
            slow = slow.next;
        }

        // Compare reversed first half with second half
        while (prev != null && slow != null) {
            if (prev.data != slow.data) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        String word = "racecar";

        // Build linked list
        Node head = new Node(word.charAt(0));
        Node current = head;
        for (int i = 1; i < word.length(); i++) {
            current.next = new Node(word.charAt(i));
            current = current.next;
        }

        // Check palindrome
        if (isPalindrome(head)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}