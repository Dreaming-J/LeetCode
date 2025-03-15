class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 0;
        int right = 0;
        for (int candy : candies)
            right = Math.max(candy, right);
        
        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (canAllocatedCandies(candies, k, mid))
                left = mid;
            else
                right = mid - 1;
        }

        return left;
    }

    private boolean canAllocatedCandies(int[] candies, long k, int mid) {
        long totalCandiesPile = 0;

        for (int idx = 0; idx < candies.length; idx++)
            totalCandiesPile += candies[idx] / mid;

        return totalCandiesPile >= k;
    }
}