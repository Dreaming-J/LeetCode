class Solution {

    public int minCapability(int[] nums, int k) {
        int totalHouses = nums.length;

        int minReward = Integer.MAX_VALUE;
        int maxReward = Integer.MIN_VALUE;
        for (int num : nums) {
            minReward = Math.min(num, minReward);
            maxReward = Math.max(num, maxReward);
        }

        while (minReward < maxReward) {
            int midReward = (minReward + maxReward) / 2;
            int possibleThefts = 0;

            for (int idx = 0; idx < totalHouses; idx++) {
                if (nums[idx] <= midReward) {
                    possibleThefts++;
                    idx++;
                }
            }

            if (possibleThefts >= k)
                maxReward = midReward;
            else
                minReward = midReward + 1;
        }

        return minReward;
    }
}