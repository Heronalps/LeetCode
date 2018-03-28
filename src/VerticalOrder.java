import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VerticalOrder {
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int offset = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        queue.offer(root);
        colQueue.offer(0);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int column = colQueue.poll();
            if (column < offset) {
                result.add(0, new ArrayList<>());
                offset = column;
            }
            else if (column - offset == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(column - offset).add(curr.val);
            if (curr.left != null){
                queue.offer(curr.left);
                colQueue.offer(column - 1);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                colQueue.offer(column + 1);
            }
        }
        return result;
    }
}
