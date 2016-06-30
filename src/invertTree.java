/**
 * Created by michael.zhang on 6/29/2016.
 */
public class invertTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode alt_root = new TreeNode (root.val);
        alt_root.left = invertTree(root.right);
        alt_root.right = invertTree(root.left);
        return alt_root;
    }
        public static TreeNode invertTree2(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode tempnode = invertTree2(root.right);
            root.right = invertTree2(root.left);
            root.left = tempnode;
            return root;
        }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.right = new TreeNode(5);

        System.out.println(root.left.left.right.val);
        //TreeNode alt_root = invertTree(root);
        //System.out.println(alt_root.right.right.left.val);
        TreeNode alt_root2 = invertTree2(root);
        System.out.println(alt_root2.right.right.left.val);
    }
}
