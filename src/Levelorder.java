import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.lang.Integer;

public class Levelorder{
	public static List<List<Integer>> levelorder(TreeNode root) {
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
				level.add(new Integer(current.val));
				if(current.left != null) queue.offer(current.left);
				if(current.right != null) queue.offer(current.right);
				levelSize--;
			}
			result.add(new LinkedList<Integer> (level));
			level.clear();
		}
		return result;
	}

    public static List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public static void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height > res.size() - 1) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(levelOrder(root));
	}
}