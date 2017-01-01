import java.util.Stack;

public class PathSumI{
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			return true;
		}
		if (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)) {
			return true;
		}
		return false;

	}

	public static boolean hasPathSum2(TreeNode root, int sum) { // Post-order Traversal
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root, previous = null;
		int total = 0;
		while(!stack.isEmpty() || current != null) {
			while(current != null) {
				stack.push(current);
				total += current.val;
				current = current.left;
			}
			current = stack.peek();
			if (current.left == null && current.right == null && total == sum) {
				return true;			
			} else {
				if (current.right != null && previous != current.right) { //
					current = current.right;
				} else {
					previous = current;
					stack.pop();
					total -= previous.val;
					current = null; // To correspond to line 23 while(current != null)
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		System.out.println(hasPathSum2(root, 22));
	}
}