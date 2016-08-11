import java.util.Arrays;

/**
 * Created by michaelzhang on 8/11/16.
 */
public class IntersectionArray2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index = 0, i = 0, j = 0;
        int[] temp = new int[nums1.length > nums2.length ? nums2.length : nums1.length]; //短数组长度是交集的最大长度
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                temp[index++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        /*int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        return result; */
        return Arrays.copyOfRange(temp, 0, index);
    }

    public static void main(String[] args) {
        IntersectionArray2 example = new IntersectionArray2();
        int[] result = example.intersect(new int[] {1,2,2,1}, new int[] {2,2});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
