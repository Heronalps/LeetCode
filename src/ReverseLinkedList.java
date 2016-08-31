import javax.xml.soap.Node;

/**
 * Created by michaelzhang on 8/30/16.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }
        else {
            ListNode newhead = new ListNode(head.val);

            while (head.next != null) {
                ListNode followingNode = new ListNode(head.next.val);
                followingNode.next = newhead;
                newhead = followingNode;
                head = head.next;
            }

            return newhead;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode Node2 = new ListNode(2);
        ListNode Node3 = new ListNode(3);

        head.next = Node2;
        head.next.next = Node3;

        ReverseLinkedList myApp = new ReverseLinkedList();
        ListNode result = myApp.reverseList(head);
        System.out.println(result.val); // Should be 3
    }
}