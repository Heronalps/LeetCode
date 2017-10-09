import java.util.*;

public class Solution {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(reverseKGroup(a, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode next = null, prev = null, current = head;
        int counter = 0;
        while (current != null) {
            current = current.next;
            counter++;
        }
        if (counter < k) {
            return head;
        }
        current = head;
        counter = k;
        //reverse first k nodes in linked list
        while (counter > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            counter--;
        }
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }

}