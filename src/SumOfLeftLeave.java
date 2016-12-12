/* public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
	}
}*/
import java.util.Stack;

public class SumOfLeftLeave{
	public static int sumOfLeftLeaves(TreeNode root) {
		int sum = 0;
		if (root == null) {
			return 0;
		} 
		if (root.left != null && root.left.left == null && root.left.right == null ) {
			sum += root.left.val;
		}
		sum += sumOfLeftLeaves(root.left);
		sum += sumOfLeftLeaves(root.right);
		return sum;

	}

	public static int traverseSum(TreeNode root) {
		int sum = 0;
		if(root == null) {
			return 0;
		} else {
			sum += root.val;
		}

		sum += traverseSum(root.left);
		sum += traverseSum(root.right);
		return sum;
	}

	public static int sumOfLeftLeaves2(TreeNode root) { //Iterative solution
		int sum = 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode current = stack.pop();
			if (current != null) { 
				if (current.left != null && current.left.left == null && current.left.right == null) {
					sum += current.left.val;
			}
				stack.push(current.left);
				stack.push(current.right);
			}
		}
		return sum;
	}  

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
	    root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(traverseSum(root)); //54 
		System.out.println(sumOfLeftLeaves2(root)); //24 
	}

} 