public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int median = quickSelect(nums, len / 2, 0, len - 1);
        int index = 0, left = 0, right = len - 1;
        while (index <= right) {
            if (nums[mapIdx(index, len)] > median) { // 所有操作，都是针对mapping index的
                swap(nums, mapIdx(index++, len), mapIdx(left++, len));
            } else if (nums[mapIdx(index, len)] < median) {
                swap(nums, mapIdx(index, len), mapIdx(right--, len));
            } else {
                index++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int mapIdx(int index, int n) {
        return (2 * index + 1) % (n | 1); // Virtual Indexing技巧
    }
    private int quickSelect(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];
        int i = start, j = end;
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                // i，j 一定要交错，nums[i]不能等于pivot，这保证了i不超过mid
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) { // 别忘了再验证一次
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (j - start + 1 >= k) {
            return quickSelect(nums, k, start, j);
        } else if (i - start + 1 <= k) {
            return quickSelect(nums, k - (i - start), i, end);
        }
        return pivot; // 上面两种情况都不符合，证明i，j 交错，中间空一个元素。
    }
}
