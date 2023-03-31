

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        ListNode l1 = new ListNode(-1); // Dummy node
        ListNode p1 = l1;
        for (int i = 0; i < n1; i++) {
            int val = sc.nextInt();
            p1.next = new ListNode(val);
            p1 = p1.next;
        }

        ListNode l2 = new ListNode(-1); // Dummy node
        ListNode p2 = l2;
        for (int i = 0; i < n2; i++) {
            int val = sc.nextInt();
            p2.next = new ListNode(val);
            p2 = p2.next;
        }

        ListNode mergedList = mergeTwoLists(l1.next, l2.next);

        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }

        return dummy.next;
    }
}
