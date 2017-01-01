/**
* @param Root of the tree, in which to find path 
* @param The sum of the path required
* @return The list of a list of Integer that the found paths have
* @author Michael Zhang 12/19/2016
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class PathSumII {
	//The return type is set up in Leetcode. Therefore, the annoucement of list and path should be List.
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		//The inner list should be converted to ArrayList when it is announced independently
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		pathSumHelper(root, sum, path, list);
		return list;
	}

	public static void pathSumHelper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> list) {
		//The type of path and list are set up in pathSum fucntion, helper can't use ArrayList as parameter type.
		//There is only one path, whose last integer will be removed when the function returns, in order to renew the path
		//No new path will be announced in the recursive function.
		
		if (root == null) return;


		// The adding strategy it uses is to add node upfront and if the path is not valid, backtrack and remove the node.
		path.add(new Integer(root.val));

		
		if (root.left == null && root.right == null && root.val == sum) {
			//The type of path is List, ArrayList(path) is the only compatible way to cast it into ArrayList.
			list.add(new ArrayList<Integer>(path));
		} else {
			pathSumHelper(root.left, sum - root.val, path, list);
			pathSumHelper(root.right, sum - root.val, path, list);
		}
		//The last node needs to be removed when it goes back to upper frame.
		path.remove(path.size() - 1);
	}

	//Concise code of same idea
	public void pathSumInner(TreeNode root, int sum, List<Integer>path, List<List<Integer>> result) {
	    path.add(root.val);
	    if(root.left == null && root.right == null)
	        if(sum == root.val) result.add(new ArrayList<Integer>(path));
	    if(root.left!=null) pathSumInner(root.left, sum-root.val, path, result);
	    if(root.right!=null)pathSumInner(root.right, sum-root.val, path, result);
	    path.remove(path.size()-1);
	}

	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
	    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
	    if(root==null) return resultList;
	    List<Integer> currentPath = new ArrayList<Integer>();
	    pathSumInner(root, sum, currentPath, resultList);
	    return resultList;
	}

	//Iteration solution of Postorder traversal
	public List<List<Integer>> pathSum3(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int SUM = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                path.add(cur.val);
                SUM+=cur.val;
                cur=cur.left;
            }
            cur = stack.peek();
            if(cur.right!=null && cur.right!=pre){
                cur = cur.right;
                continue;
            } 
            if(cur.left==null && cur.right==null && SUM==sum) 
                res.add(new ArrayList<Integer>(path));
  
            pre = cur;
            stack.pop();
            path.remove(path.size()-1);
            SUM-=cur.val;
            cur = null;
        }
        return res;
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
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		System.out.println(pathSum(root, 22));
	}
}