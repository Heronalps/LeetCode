import java.util.ArrayList;
import java.util.List;

public class PathSumIISolution {
    ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        List<Integer> list = new ArrayList<Integer>();

        PreOrder(root,list);
        return result;
    }

    public void PreOrder(TreeNode node,List<Integer> list){
        if( node != null){
            //Every recursion carries the high level arrayList, 
            //but every time create a new one that inherits the previous node data.
            ArrayList<Integer> newlist = new ArrayList<Integer>(list);
            newlist.add(node.val);
            if(node.left == null && node.right == null){// leaf node
                if(getsum(newlist) == sum){
                    result.add(newlist);
                }
            }
            
            PreOrder(node.left,newlist);
            PreOrder(node.right,newlist);
        }
        //At the end of the function, if the node is null, it automatically return to the higher-level frame. 
        //No return is needed. 
    }

    public int getsum(List<Integer> list){
        int count = 0 ;
        for(Integer i : list){
            count+=i;
        }
        return count;
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
        PathSumIISolution sol = new PathSumIISolution();
        System.out.println(sol.pathSum(root, 22));
    }
}
