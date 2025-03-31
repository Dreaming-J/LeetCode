class Solution {
    public long putMarbles(int[] weights, int k) {
        int marbleCounts = weights.length;
        int[] pairWeights = new int[marbleCounts - 1];

        for (int idx = 0; idx < marbleCounts - 1; idx++)
            pairWeights[idx] = weights[idx] + weights[idx + 1];
        
        Arrays.sort(pairWeights);

        long answer = 0L;

        for (int idx = 0; idx < k - 1; idx++)
            answer += pairWeights[marbleCounts - 1 - (idx + 1)] - pairWeights[idx];

        return answer;
    }
}