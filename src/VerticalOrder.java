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
        // 用offset来表示左边界

        Queue<TreeNode> queue = new LinkedList<>();
        // 两个queue对应的技巧，可以省去写Wrapper class

        Queue<Integer> colQueue = new LinkedList<>();
        queue.offer(root);
        colQueue.offer(0);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int column = colQueue.poll();
            if (column < offset) {
                // 拓展左边界
                result.add(0, new ArrayList<>());
                offset = column;
            }
            else if (column - offset == result.size()) {
                // 拓展右边界
                result.add(new ArrayList<>());
            }
            result.get(column - offset).add(curr.val);
            // column - offset就是正确位置

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
