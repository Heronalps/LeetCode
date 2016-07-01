/**
 * Created by michael.zhang on 6/29/2016.
 */
public class moveZeros {
    public static void moveZeroes(int[] nums) {
        int pointer = -1;
        int counter = 0; //遇到零的个数
        //基本思想：从左向右扫描，每个非零元素都向前移动count个位置，末尾补零。因为从左向右扫描，所以不会覆盖。
        while (pointer < nums.length - 1) {
            pointer++;
            while (nums[pointer] == 0 && pointer < nums.length - 1) {
                pointer++;
                counter++;
            }
            nums[pointer - counter] = nums[pointer];
        }
        //注意末尾数的处理，因为扫描到它会溢出，所以不管是零还是非零，都向前移动。
        //因为循环体外，pointer要再用到一次，所以必须以-1开始，++操作在前,以应付全零数组的Corner Case
        nums[pointer - counter] = nums[pointer];
        pointer = nums.length - 1; //从最后一位开始补counter个零
        while (counter > 0) {
            nums[pointer--] = 0; //先置零，再--操作
            counter--;
        }
    }
    public static void moveZeroes2(int[] nums){
        //思想与上面方法基本一致，但不track零的个数，而是用index指示应该移动到的位置，代码简洁了太多，还包含了Corner Case
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void moveZeroes3(int[] nums){
        int index = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0) {
                swap(nums, index++, i);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        //int[] arr = {0, 0};
        int[] arr = {0, 0, 1, 0, 3, 12, 0};
        moveZeroes3(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}