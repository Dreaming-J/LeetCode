class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        long answer = 0L;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long triplet = (long) (nums[i] - nums[j]) * nums[k];
                    answer = Math.max(triplet, answer);
                }
            }
        }

        return answer;
    }
}