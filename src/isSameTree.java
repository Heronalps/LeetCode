import java.util.Stack;

/**
 * Created by michaelzhang on 7/1/16.
 */
public class isSameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        } else if (p.val != q.val) {
            return false;
        }
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null ^ q == null){
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static boolean isSameTree3(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        Stack<TreeNode> treeP = new Stack<TreeNode>();
        Stack<TreeNode> treeQ = new Stack<TreeNode>();
        treeP.add(p);
        treeQ.add(q);
        while (treeP.size() != 0 && treeQ.size() != 0){
            p = treeP.pop();
            q = treeQ.pop();

            if (p == null || q == null) {
                if (p != q) {
                    return false;
                } else {
                    continue;
                }
            }
            if (p.val != q.val) return false;

            treeP.add(p.right);
            treeP.add(p.left);

            treeQ.add(q.right);
            treeQ.add(q.left);
        }
        return treeP.size() == treeQ.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        /*root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.left.left.right = new TreeNode(5);*/

        System.out.println(isSameTree3(root, root2));

    }
}

