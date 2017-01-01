import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

public class LevelorderBottom{
	public static List<List<Integer>> levelorderBottom(TreeNode root) {
		LinkedList<Integer> level = new LinkedList<Integer>();
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {
			return result;
		} else {
			queue.offer(root);
		}
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			while(levelSize != 0){
				TreeNode current = queue.poll();
				level.add(current.val);
				if(current.left != null) queue.offer(current.left);
				if(current.right != null) queue.offer(current.right);
				levelSize--;
			}
			result.addFirst(new LinkedList<Integer> (level));
			level.clear();
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(levelorderBottom(root));
	}
}