/**
 * Created by michaelzhang on 9/11/16.
 */
public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++ ) {
            result[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                } else {
                    result[i] *= nums[j];
                }
            }
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n =nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n ; i++){
            result[i] = 1;
        }
        int left = 1, right = 1;
        //如果用两次循环,用中间变量就可以解决元素初始化问题;如果只用一次循环,需要把Result全部初始化为1.
        //两个中间变量,只需要一次循环。如果只用一个或者不用中间变量,则需要两次循环,因为要把正反两个Array的中间结果分离.
        for (int i = 0; i < n ; i++) {
            result[i] *= left;
            left *= nums[i];
            result[n - i - 1] *= right;
            right *= nums[n - i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4};
        productExceptSelf myApp = new productExceptSelf();
        for (int n : myApp.productExceptSelf2(myArray)) {
            System.out.println(n);
        }
    }
}
