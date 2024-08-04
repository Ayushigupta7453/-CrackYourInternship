
class Solution {
    public int maxProduct(int[] nums) {
         int n = nums.length;
        if (n == 0) return 0;

        int[] maxDP = new int[n];
        int[] minDP = new int[n];

        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0) {
                maxDP[i] = Math.max(nums[i], maxDP[i - 1] * nums[i]);
                minDP[i] = Math.min(nums[i], minDP[i - 1] * nums[i]);
            } else {
                maxDP[i] = Math.max(nums[i], minDP[i - 1] * nums[i]);
                minDP[i] = Math.min(nums[i], maxDP[i - 1] * nums[i]);
            }
            maxProduct = Math.max(maxProduct, maxDP[i]);
        }

        return maxProduct;
    }
}