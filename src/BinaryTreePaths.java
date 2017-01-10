import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePaths{
	public static List<String> binaryTreePaths(TreeNode root){
		List<String> result = new ArrayList<>();
		if (root != null) helper(root, "", result);
		return result;
	}

	public static void helper(TreeNode root, String path, List<String> result) {
		if (root.left == null && root.right == null) {
			result.add(path + root.val);
			return;
		}

		path = path + root.val + "->";
		if(root.left != null) helper(root.left, path, result);
		if(root.right != null) helper(root.right, path, result);
	}

	public static List<String> binaryTreePaths2(TreeNode root) {
    List<String> list=new ArrayList<String>();
    Stack<TreeNode> sNode=new Stack<TreeNode>();
    Stack<String> sStr=new Stack<String>();
    
    if(root==null) return list;
    sNode.push(root);
    sStr.push("");
    while(!sNode.isEmpty()) {
        TreeNode curNode=sNode.pop();
        String curStr=sStr.pop();
        
        if(curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
        if(curNode.left!=null) {
            sNode.push(curNode.left);
            sStr.push(curStr+curNode.val+"->");
        }
        if(curNode.right!=null) {
            sNode.push(curNode.right);
            sStr.push(curStr+curNode.val+"->");
        }
    }
    return list;
}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.left.right = new TreeNode(7);
		
		System.out.println(binaryTreePaths2(root));

	}
}