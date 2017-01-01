import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PathSumIII {
	public static int pathSum1(TreeNode root, int sum) {
		int counter = 0;
		//Use ArrayList instead of hashset is because the node could be duplicated, like [0, 1, 1]
		ArrayList<Integer> sumList = new ArrayList<>();
		int result = pathSumHelper(root, sum, sumList, counter);
		return result;
	}

	public static int pathSumHelper(TreeNode root, int sum, ArrayList<Integer> sumList, int counter) {
		if (root == null) {
			return 0;
		} 
		ArrayList<Integer> newList = new ArrayList<>(); 
		// Every node will have its own arraylist that has all values minus root.val  of parent's list and add one with sum - root.val
		for (Integer n : sumList ) {
			newList.add(n - root.val);
		}
		newList.add(sum - root.val);
		
		for (int n : newList ) {
			if (n == 0) { //If a zero is found, meaning a path is confirmed at this node. Counter++
				counter++;
			}
		}

		counter += pathSumHelper(root.left, sum, newList, 0); 
		//Reset the counter every time going downwards and add it up to current one when return.
		counter += pathSumHelper(root.right, sum, newList, 0);
		return counter;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		root.right = new TreeNode(-3);
		root.right.right = new TreeNode(11);

		System.out.println(pathSum1(root, 8));
	}
}