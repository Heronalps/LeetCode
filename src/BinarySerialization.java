import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by michaelzhang on 2/5/17.
 */
public class BinarySerialization {
    public static String serialize(TreeNode root){
//Sanity Check
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();
        }

//BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder level = new StringBuilder();
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0){
                TreeNode current = queue.poll();
                if (current == null) {
                    level.append("#,");
                    size--;
                    continue;
                }
                level.append(current.val + ",");
                queue.offer(current.left);
                queue.offer(current.right);
                size--;
            }
            result.append(level);
            level.delete(0, level.length());
        }
        while(result.charAt(result.length() - 2) == '#') {
            result.delete(result.length() - 2, result.length());
        }
        return result.delete(result.length() - 1, result.length()).toString();
    }

    public static TreeNode deserialize(String data) {
        //Sanity check
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> parent = new LinkedList<>();
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '#') {
                queue.offer(null);
                i++;
                continue;
            }
            int offset = i;
            while (offset < data.length() && data.charAt(offset) != ',') {
                offset++;
            }
            int value = Integer.parseInt(data.substring(i, offset));
            TreeNode current = new TreeNode(value);
            queue.offer(current);
            i = offset;
        }
        TreeNode root = queue.poll();
        parent.offer(root);
        while(!queue.isEmpty()) {
            TreeNode father = parent.poll();
            TreeNode left = queue.poll();
            if (left != null) {
                parent.offer(left);
            }
            TreeNode right = queue.poll();
            if (right != null) {
                parent.offer(right);
            }
            father.left = left;
            father.right = right;
        }
        return root;
    }

    public static TreeNode deserialize2(String data) {
        if (data.equals("{}")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(serialize(root));
        //String data = serialize(root);
        String data = "{1,2,3,11,#,4,5,#,#,6,7,#,10,#,#,8,9,#,#,12,13,#,#,#,#,#,14}";
        TreeNode root2 = deserialize2(data);
        System.out.println();

    }
}
