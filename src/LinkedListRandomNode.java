import java.util.Random;

/**
 * Created by michaelzhang on 9/10/16.
 */
public class LinkedListRandomNode {

    int length;
    ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        this.length = length;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int value = rand.nextInt(this.length);
        ListNode result = this.head;
        for (int i = 0; i < value; i++) {
            result = result.next;
        }
        return result.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkedListRandomNode obj = new LinkedListRandomNode(head);
        System.out.println(obj.getRandom());

    }
}

