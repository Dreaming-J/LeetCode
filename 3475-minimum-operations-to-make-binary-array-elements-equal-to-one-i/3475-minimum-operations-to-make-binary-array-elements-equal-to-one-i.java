class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
    
        for (int idx = 0; idx < nums.length - 2; idx++) {
            if (nums[idx] == 0) {
                nums[idx] ^= 1;
                nums[idx + 1] ^= 1;
                nums[idx + 2] ^= 1;
                count++;
            }
        }

        if (nums[nums.length - 2] != 1 || nums[nums.length - 1] != 1)
            return -1;

        return count;
    }
}