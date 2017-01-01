public class DeleteDuplicate{
	public static ListNode deleteDuplicate(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode headAlt = head;
		while (head.next != null) {
			if (head.val != head.next.val) {
				head = head.next;
			} else {
				head.next = head.next.next;
			}
		}
		return headAlt;

	}

	public static ListNode deleteDuplicate2(ListNode head) {
		if(head == null || head.next == null)return head;
        head.next = deleteDuplicate2(head.next);
        return head.val == head.next.val ? head.next : head;
	}

	public static ListNode deleteDuplicate3(ListNode head) {
        ListNode list = head;
         
         while(list != null) {
        	 if (list.next == null) {
        		 break;
        	 }
        	 if (list.val == list.next.val) {
        		 list.next = list.next.next;
        	 } else {
        		 list = list.next;
        	 }
         }
         
         return head;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		//head.next.next.next.next = new ListNode(3);
		
		ListNode newHead = deleteDuplicate(head);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}