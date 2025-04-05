class Solution {
    public static int answer;

    public int subsetXORSum(int[] nums) {
        answer = 0;

        subset(0, 0, nums);

        return answer;
    }

    public void subset(int idx, int xor, int[] nums) {
        if (idx == nums.length) {
            answer += xor;
            return;
        }

        subset(idx + 1, xor ^ nums[idx], nums);
        subset(idx + 1, xor, nums);
    }
}