/**
 * Created by michaelzhang on 7/1/16.
 */
public class deleteNode {
    public static void deleteNode(ListNode node) {

        if (node == null) {
            return;
        } else if (node.next == null) {
            node.next = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(1);

        //deleteNode(root.next.next);
        System.out.println(root.next.next.next.val == root.val);
    }
}
