import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree {
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Deque<TreeNode> dequeue = new LinkedList<TreeNode>();
		queue.offer(root.left);
		queue.offer(root.right);
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size > 0){
				TreeNode current = queue.poll();
				if(current != null) queue.offer(current.left);
				if(current != null) queue.offer(current.right);
				dequeue.add(current);
				size--;
			}
			if (dequeue.size() % 2 != 0) {
				return false;
			}
			while(!dequeue.isEmpty()){
				TreeNode first = dequeue.pollFirst();
				TreeNode last = dequeue.pollLast();
				if (first == null || last == null) {
					if (first != last) { // null equals to null
						return false;
					}		
				} else if (first.val != last.val){
					return false;
				}
			}
		}
		return true;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(isSymmetric(root));

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(2);
		root2.left.right = new TreeNode(3);
		root2.right.right = new TreeNode(3);
		System.out.println(isSymmetric(root2));
	}	
}