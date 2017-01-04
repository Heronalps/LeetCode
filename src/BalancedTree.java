public class BalancedTree {
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

	}

	public static int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}

	public static boolean isBalanced2(TreeNode root) {
		return dfs(root) != -1;
	}

	public static int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = dfs(root.left);
		if (left == -1) {
			return -1;
		}
		int right = dfs(root.right);
		if (right == -1) {
			return -1;
		}

		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		//root.left.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		System.out.println(isBalanced2(root));
	}
}