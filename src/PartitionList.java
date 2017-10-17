public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.val < x) {
            head = head.next;
        }
        ListNode pointer = head.next;
        ListNode prevPointer = head;

        while( pointer != null) {

            while (pointer != null && pointer.val >= x) {
                prevPointer = pointer;
                pointer = pointer.next;
            }
            // insert element ahead of the head
            if (pointer != null){
                prevPointer.next = pointer.next;
                pointer.next = head.next;
                head.next = pointer;
                pointer = prevPointer.next;
                head = head.next;
            }
        }

        return dummy.next;
    }
}
