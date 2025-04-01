class Solution {
    public long mostPoints(int[][] questions) {
        int questionCounts = questions.length;
        long[] maxPoints = new long[questionCounts + 1];

        for (int idx = questionCounts - 1; idx >= 0; idx--) {
            int point = questions[idx][0];
            int nextIdx = idx + questions[idx][1] + 1;

            maxPoints[idx] = nextIdx >= questionCounts ?
                point :
                point + maxPoints[nextIdx];

            maxPoints[idx] = Math.max(maxPoints[idx], maxPoints[idx + 1]);
        }

        return maxPoints[0];
    }
}