public class MergeTwoLists{
	public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode head = (l1.val <= l2.val) ? l1 : l2;

		while(l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				l1 = connect(l1, l2);
			} else {
				l2 = connect(l2, l1);
			}
		}
		return head;
	}

	public static ListNode connect(ListNode small, ListNode large) {
		ListNode head1 = small;
		int counter = 0;

		while (head1 != null && head1.val <= large.val ){
			head1 = head1.next; 
			counter++;
		}
		for (int i = 1; i < counter ; i++) {
			small = small.next;
		}
		small.next = large;
		return head1;
	}


	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;

		if(l1.val < l2.val) {
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists2(l2.next, l1);
			return l2;
		}
	}

	public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode t1 = l1;
		ListNode t2 = l2;

		//whichever list is starting with least, make it t1;
		if(t1.val > t2.val) {
			ListNode temp = t1;
			t1 = t2;
			t2 = temp;
		}
		l1 = t1; //this is what you return eventually

		while(t1.next!=null && t2!=null) {
			if(t1.val <= t2.val && t1.next.val <= t2.val) {
				t1 = t1.next; // proceed if both are less.
			}else if (t1.val <= t2.val){
				// if t2.val comes in b/w, connect t2,
				// and make t1.next as t2.
				ListNode temp = t2;
				t2 = t1.next;
				t1.next = temp;
			}
		}
		//If the first list reaches end, just connect to second list.
		if(t1.next == null) {
			t1.next = t2;
		}
		return l1;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node5 = new ListNode(5);
		ListNode node7 = new ListNode(7);
		ListNode node9 = new ListNode(9);
		ListNode node2 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		ListNode node6 = new ListNode(6);
		ListNode node8 = new ListNode(8);
		ListNode node10 = new ListNode(10);

		node1.next = node2;
		node2.next = node5;
		node3.next = node4;
		node4.next = node6;
		/*node7.next = node8;
		node4.next = node5;
		node6.next = node7;
		node8.next = node10;
*/
		ListNode head = mergeTwoLists3(node1, node3);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}


	}
}