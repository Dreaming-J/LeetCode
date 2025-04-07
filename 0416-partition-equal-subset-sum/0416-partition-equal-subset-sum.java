class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();

        if (totalSum % 2 != 0)
            return false;
            
        int targetSum = totalSum /= 2;

        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int cur = targetSum; cur >= num; cur--) {
                dp[cur] = dp[cur] | dp[cur - num];

                if (dp[targetSum])
                    return true;
            }
        }

        return false;
    }
}