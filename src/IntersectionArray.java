import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by michael.zhang on 7/1/2016.
 */
public class IntersectionArray {
    // Sort and Merge
    public static int[] intersection(int[] nums1, int[] nums2) {
        //Sort and merge
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index = 0, i = 0, j = 0;
        int[] temp = new int[nums1.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || (temp[index - 1] != nums1[i])) { //此判断条件实现去除重复结果
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] result = new int[index];
        for (int k = index - 1; k >= 0; k--, index--) {
            result[k] = temp[index - 1];
        }
        return result;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        //HashSet

        if (nums1 == null || nums2 == null) {
            return null;
        }
        HashSet<Integer> origin = new HashSet<Integer>();
        HashSet<Integer> temp = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            origin.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (origin.contains(nums2[j])) {
                temp.add(nums2[j]);
            }
        }

        int[] result = new int[temp.size()];
        int index = 0;
        for (int k : temp) {
            result[index++] = k;
        }

        return result;
    }

    public static int[] intersection3(int[] nums1, int[] nums2) {
        int[] origin;
        int[] comparator;

        //Sort and Binary Search
        if (nums1.length > nums2.length) {
            Arrays.sort(nums1);
            origin = nums1;
            comparator = nums2;
        } else {
            Arrays.sort(nums2);
            origin = nums2;
            comparator = nums1;
            //为了提高效率，应付一个长数组和一个单元素数组的最差情况
        }

        HashSet<Integer> hash = new HashSet<Integer>();
        for (int i = 0; i < comparator.length ; i++) {
            if (binarySearch(comparator[i], origin)) {
                hash.add(comparator[i]);
            }
        }

        int[] result = new int[hash.size()];
        int index = 0;
//        Iterator<Integer> it = hash.iterator();
//        while (it.hasNext()) {
//            result[index++] = it.next();
//        }
        for (int i : hash) {
            result[index++] = i;
        }
        return result;
    }

    public static boolean binarySearch(int target, int[] sortedArray) {
        int start = 0;
        int end = sortedArray.length - 1;

        while (end >= start) {
            int mid = (start + end) / 2;
            if (sortedArray[mid] == target) {
                return true;
            } else if (target > sortedArray[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] intersection = intersection3(nums1, nums2);
        for (int i : intersection){
            System.out.println(i);
        }
    }
}
