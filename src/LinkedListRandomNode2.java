import java.util.Random;

/**
 * Created by michaelzhang on 9/10/16.
 */
public class LinkedListRandomNode2 {
    ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode2(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int result = 0;
        for (int i = 1; this.head != null ; i++) {
            //nextInt(n)在n为1的时候,只会返回0,所以实现了result的初始化,把head.val写入。
            //在后面的iteration中,返回的随机数和0比较,依然遵循k/(k+i)的概率进行选择。
            //单单改成了0,便把以上两步合并,此步很妙。
            if (rand.nextInt(i) == 0) {
                result = this.head.val;
            }
            this.head = this.head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkedListRandomNode2 obj = new LinkedListRandomNode2(head);
        System.out.println(obj.getRandom());

    }
}
