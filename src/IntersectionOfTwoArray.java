import java.util.*;

public class IntersectionOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        //Binary Search
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < len2; i++) {
            if (i > 0 && nums2[i - 1] == nums2[i]) {
                continue;
            }
            int start = 0, end = len1 - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums1[mid] > nums2[i]) {
                    end = mid;
                }
                else if (nums1[mid] <= nums2[i]) {
                    start = mid;
                }
            }
            if (nums1[start] == nums2[i]) {
                result.add(nums2[i]);
            }
            if (nums1[end] == nums2[i] && nums1[start] != nums1[end]) {
                result.add(nums2[i]);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    // Two pointers
    public int[] intersection2(int[] nums1, int[] nums2) {
        // write your code here
        // Two pointers
        int pointer1 = 0, pointer2 = 0, index = 0;
        int[] temp = new int[nums1.length];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(pointer1 < nums1.length && pointer2 < nums2.length) {

            while (pointer1 < nums1.length - 1 && nums1[pointer1] == nums1[pointer1 + 1]) {
                pointer1++;
            }

            while (pointer2 < nums2.length - 1 && nums2[pointer2] == nums2[pointer2 + 1]) {
                pointer2++;
            }

            if (nums1[pointer1] == nums2[pointer2]) {
                temp[index++] = nums1[pointer1];
                pointer1++;
                pointer2++;
            }
            else if (nums1[pointer1] > nums2[pointer2]){
                pointer2++;
            }
            else {
                pointer1++;
            }
        }

        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    // Hash Set
    public int[] intersection3(int[] nums1, int[] nums2) {
        // write your code here
        // Hashset
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }
        for (int i = 0; i < nums2.length; i++) {
            //System.out.println("num : " + set.contains(nums2[i]));
            if (set.contains(nums2[i])){
                ans.add(nums2[i]);
            }
        }
        int[] result = new int[ans.size()];
        int index = 0;
        Iterator it = ans.iterator();
        while (it.hasNext()) {
            result[index++] = (int) it.next();
        }
        return result;
    }

}
