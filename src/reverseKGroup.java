public class reverseKGroup {

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
