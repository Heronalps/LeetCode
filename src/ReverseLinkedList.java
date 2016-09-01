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


    public ListNode reverseList1(ListNode head) {

        //Iterative Solution
        /* Head: 当前正在处理的Node
        * newHead： 被反向指向的Node，最后一步变成了new head. 有了这个标记，即使正向指针断开，也能找到并反向指向
        * next： 下一个要处理的Node*/

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next; //下一个head
            head.next = newHead; //让head向反方向指
            newHead = head; //newHead向前移动
            head = next; //head向前移动
        }

        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        return reverseListHelper(head, null);
    }
    //因为Java不能返回两个以上的值，如果又不想用Wrapper的话，就要用这种Overloading的技巧

    public ListNode reverseListHelper(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }

        ListNode next = head.next;
        head.next = newHead;
        return reverseListHelper(next, head);//把iterative solution中两个步进合二为一
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode Node2 = new ListNode(2);
        ListNode Node3 = new ListNode(3);

        head.next = Node2;
        head.next.next = Node3;

        ReverseLinkedList myApp = new ReverseLinkedList();
        ListNode result = myApp.reverseList2(head);
        System.out.println(result.val); // Should be 3
    }
}