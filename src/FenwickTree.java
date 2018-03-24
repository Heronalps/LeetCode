public class FenwickTree {
    int[] BIT;
    int[] nums;

    public FenwickTree(int[] nums) {
        this.nums = nums;
        BIT = new int[nums.length + 1];
        build();
    }
    public void build() {
        for (int i = 1; i <= nums.length; i++)
        {
            BIT[i]=nums[i - 1];
            for (int j=i - 2; j >= i-lowbit(i); j--)
                BIT[i]+=nums[j];
        }
    }
    public int lowbit(int i) {
        return i & (-i);
    }
    public static void main(String[] args) {
        FenwickTree tree = new FenwickTree(new int[] {3,2,-1,6,5,4,-3,3,7,2,3});
        for (int num : tree.BIT) {
            System.out.println(num);

        }
    }
}
