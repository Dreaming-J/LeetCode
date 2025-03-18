class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxCount = 0;
        int count = 0;
        int bit = 0x0;

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if ((bit & nums[right]) == 0) {
                bit |= nums[right++];
                count++;
            }
            else {
                bit &= ~nums[left++];
                count--;
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}