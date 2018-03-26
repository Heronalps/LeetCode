import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int source : map.get(stones[i])){
                int step = stones[i] - source;
                // 如果HashSet中直接写入步数，可以省略这一步。

                for (int k = step - 1; k <= step + 1; k++) {
                    if (k > 0 && map.containsKey(stones[i] + k)) {
                        map.get(stones[i] + k).add(stones[i]);
                    }
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }


    public static void main(String[] args) {

        int[][] food = new int[][] {{1,2}, {3,4}};
        List<int[]> kitchen = new LinkedList<>(Arrays.asList(food));
        int[] a1 = {1,2};
        int[] a2 = {1,2};
        int[] a3 = {2,3};
        System.out.println(a1 == a2);
        System.out.println(Arrays.equals(a1, a2));
        System.out.println(Arrays.equals(a1, a3));
    }
}