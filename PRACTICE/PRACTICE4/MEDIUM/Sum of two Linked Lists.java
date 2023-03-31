import java.util.*;
class ListNode {
int val;
ListNode next;
public ListNode(int val) {
this.val = val;
this.next = null;
}
}

public class Main {
public static ListNode reverse(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    ListNode next = null;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    int carry = 0;
    l1=reverse(l1);
    l2=reverse(l2);
    while (l1 != null || l2 != null || carry == 1) {
        int sum = 0;
        if (l1 != null) {
            sum = sum + l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }
        sum = sum + carry;
        carry = sum / 10;
        ListNode node = new ListNode(sum % 10);
        curr.next = node;
        curr = curr.next;
    }
    return reverse(dummy.next);
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    ListNode l1 = new ListNode(scanner.nextInt());
    ListNode l1Curr = l1;
    for (int i = 1; i < n; i++) {
        l1Curr.next = new ListNode(scanner.nextInt());
        l1Curr = l1Curr.next;
    }
    ListNode l2 = new ListNode(scanner.nextInt());
    ListNode l2Curr = l2;
    for (int i = 1; i < m; i++) {
        l2Curr.next = new ListNode(scanner.nextInt());
        l2Curr = l2Curr.next;
    }
    ListNode result = addTwoNumbers(l1, l2);
    while (result != null) {
        System.out.print(result.val + " ");
        result = result.next;
    }
}
}
