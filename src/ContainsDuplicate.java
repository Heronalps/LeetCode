import java.util.HashSet;

/**
 * Created by michael.zhang on 8/10/2016.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> mySet = new HashSet<Integer>(nums.length); //用Length构造HashSet可以节省空间
        for (int i = 0; i < nums.length ; i++) {
            if (mySet.contains(nums[i])) {
                return true;
            } else {
                mySet.add(nums[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate example = new ContainsDuplicate();
        Boolean result = example.containsDuplicate(new int[] {1,2,3,4,4});
        System.out.println(result);
    }

}
