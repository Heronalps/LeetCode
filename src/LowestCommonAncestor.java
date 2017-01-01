public class LowestCommonAncestor{
	public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		} else if (root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor1(root.left, p, q);
		TreeNode right = lowestCommonAncestor1(root.right, p, q);

		if (left != null && right == null) {
			return left;
		} else if (left == null && right != null) {
			return right;
		} else if (left != null && right != null) {
			return root;
		}

		return null;
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} 
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.right = new TreeNode(9);
		root.right.left = new TreeNode(7);
		TreeNode result = lowestCommonAncestor(root, root.left, root.left.right);
		System.out.println(result.val);
	}
}