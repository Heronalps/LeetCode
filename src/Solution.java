import java.math.BigInteger;
import java.util.*;

class Solution {
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        inorder(root, 0, 0, result);
        return result;
    }
    private static int inorder(TreeNode root, int column, int offset, List<List<Integer>> result) {
        if (root == null) {
            return offset;
        }
        if (column < offset) {
            result.add(0, new ArrayList<>());
            offset = column;
        }
        else if (column - offset == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(column - offset).add(root.val);
        int left = inorder(root.left, column - 1, offset, result);
        inorder(root.right, column + 1, left, result);
        return left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        verticalOrder(root);
    }

}

