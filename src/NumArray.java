class NumArray {
    int[] BIT;
    int[] array;
    public NumArray(int[] nums) {
        array = new int[nums.length];
        BIT = new int[nums.length + 1];
        build(nums);
    }

    public void update(int i, int val) {
        int delta = val - array[i]; // 求出delta
        array[i] = val; // 赋值到成员数组
        i++; // BIT下标大1
        while (i < BIT.length) {
            BIT[i] += delta;
            i += lowbit(i); // 对所有同根siblings进行更新
        }
    }

    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
        // i，j 均是 inclusive，所以i - 1
    }

    private void build(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]); // 用update构建build逻辑
        }
    }

    private int sum (int k) { // inclusive
        int sum = 0;
        for (int i = k + 1; i > 0; i -= lowbit(i)) {
            // i = k + 1转化下标，累加所有根节点

            sum += BIT[i];
        }
        return sum;
    }

    private int lowbit(int i) {
        return i & (-i);
    }
}
