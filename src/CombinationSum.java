import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by michaelzhang on 2/6/17.
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        //Sanity check
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> comb = new ArrayList<>();
        helper(result, comb, 0, candidates, target);
        return result;
    }
    public static void helper(List<List<Integer>> result,
                              List<Integer> comb,
                              int startIndex,
                              int[] candidates,
                              int target) {
        //Base case to do
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            if (i != startIndex && candidates[i - 1] == candidates[i]) {
                continue;
            }
            comb.add(candidates[i]);
            helper(result, comb, i + 1, candidates, target - candidates[i]);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {10,1,6,7,2,1,5}, 8));
    }
}
