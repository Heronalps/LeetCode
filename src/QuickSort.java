/**
 * Created by michaelzhang on 2/9/17.
 */
public class QuickSort {
    public static ListNode insert(ListNode node, int x) {
        //Sanity check
        if (node == null){
            node = new ListNode(x);
            return node;
        }
        while(node.val > x || node.next.val < x && node.next.val > node.val) {
            node = node.next;
        }
        ListNode temp = node.next;
        node.next = new ListNode(x);
        node.next.next = temp;
        return node.next;
    }

    public static void main(String[] args) {
        System.out.println(insert(null, 4));
    }
}
