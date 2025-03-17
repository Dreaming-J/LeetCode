class Solution {
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0)
            return false;

        Arrays.sort(nums);

        for (int idx = 0; idx < nums.length; idx += 2) {
            if (nums[idx] != nums[idx + 1])
                return false;
        }

        return true;
    }
}