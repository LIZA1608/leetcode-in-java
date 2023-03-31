import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> count = new HashMap<>();
        ListNode curr = head;

        // count the number of occurrences of each value
        while (curr != null) {
            count.put(curr.val, count.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }

        // iterate through the linked list again and delete nodes with count > 1
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        curr = dummy;

        while (curr.next != null) {
            if (count.get(curr.next.val) > 1) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // create a linked list from the input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = null, tail = null;

        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            ListNode node = new ListNode(val);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        // call the deleteDuplicates function
        Main solution = new Main();
        ListNode result = solution.deleteDuplicates(head);

        // print the updated linked list
        if (result == null) {
            System.out.println("-1");
        } else {
            while (result != null) {
                System.out.print(result.val + " ");
                result = result.next;
            }
        }
    }
}
