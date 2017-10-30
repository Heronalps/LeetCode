import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] numbers, int target) {
        // write your code here
        Arrays.sort(numbers);
        int len = numbers.length;
        int result = 0, minDiff = Integer.MAX_VALUE;
        for (int end = len - 1; end > 1; end--) {
            int start = 0, pointer = 1;
            int diff = target - numbers[end];
            while (start + 1 < end) {
                int cur = numbers[start] + numbers[pointer];
                while (pointer < end - 1 && Math.abs(cur - diff) > minDiff) {
                    pointer++;
                }

                if (cur == diff) {
                    return target;
                }
                // cur - diff = num[start] + num[end] + num[pointer] - target
                else if (Math.abs(cur - diff) < minDiff) {
                    minDiff = Math.abs(cur - diff);
                    result = cur + numbers[end];
                    //System.out.println("Start : " + start);
                    //System.out.println("End : " + end);
                    //System.out.println("pointer : " + pointer);
                    //System.out.println("Start num: " + numbers[start]);
                    //System.out.println("End num: " + numbers[end]);
                    //System.out.println("pointer num : " + numbers[pointer]);
                    System.out.println("result : " + result);
                }
                pointer++;

                if (pointer > end - 1) {
                    start++;
                    System.out.println("start : " + start);
                    pointer = start + 1;
                }
            }
        }
        return result;
    }
}
