public class SwapPairs{
	public static ListNode swapPairs(ListNode head){
		if (head == null || head.next == null) {
			return head;
		}

		ListNode front = head, end = head.next, prev = head, result = head.next;
		while(end.next != null && end.next.next != null){
			front.next = end.next;
			end.next = front;
			end = front.next.next;
			front = front.next;
			prev.next = end;
			prev = front;
		}
		front.next = end.next;
		end.next = front;

		return result;
	}



	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next= new ListNode(5);
		ListNode newHead = swapPairs(head);
		while(newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
}