class Solution {
    public long maximumTripletValue(int[] nums) {
        long answer = 0;

        int iMax = 0; //Max value of nums[i]
        int ijMax = 0; // Max value of (nums[i] - nums[j])

        for (int num : nums) {
            answer = Math.max((long) ijMax * num, answer);

            ijMax = Math.max(iMax - num, ijMax);

            iMax = Math.max(num, iMax);
        }

        return answer;
    }
}