class Solution {

    private static final int MOD = 1_000_000_007;

    public int maximumScore(List<Integer> nums, int k) {
        int numSize = nums.size();

        // Calculate the prime score
        int[] primeScores = new int[numSize];

        for (int idx = 0; idx < numSize; idx++) {
            int num = nums.get(idx);

            for (int factor = 2; factor <= Math.sqrt(num); factor++) {
                if (num % factor != 0)
                    continue;
                
                primeScores[idx]++;

                while (num % factor == 0)
                    num /= factor;
            }

            if (num >= 2)
                primeScores[idx]++;
        }

        // Calculate next & prev dominant
        int[] prevDominant = new int[numSize];
        int[] nextDominant = new int[numSize];
        Arrays.fill(prevDominant, -1);
        Arrays.fill(nextDominant, numSize);

        Stack<Integer> decreasingPrimeScoreStack = new Stack<>();

        for (int idx = 0; idx < numSize; idx++) {
            while (
                !decreasingPrimeScoreStack.isEmpty() &&
                primeScores[idx] > primeScores[decreasingPrimeScoreStack.peek()]
            ) {
                int topIdx = decreasingPrimeScoreStack.pop();

                nextDominant[topIdx] = idx;
            }

            if (!decreasingPrimeScoreStack.isEmpty())
                prevDominant[idx] = decreasingPrimeScoreStack.peek();
            
            decreasingPrimeScoreStack.push(idx);
        }

        // Calculate the number of subarrays
        long[] numOfSubarrays = new long[numSize];
        for (int idx = 0; idx < numSize; idx++)
            numOfSubarrays[idx] = ((long) nextDominant[idx] - idx) * (idx - prevDominant[idx]);

        PriorityQueue<int[]> processingQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0])
                return Integer.compare(o1[1], o2[1]);
            
            return Integer.compare(o2[0], o1[0]);
        });

        for (int idx = 0; idx < numSize; idx++)
            processingQueue.add(new int[] {nums.get(idx), idx});
        
        long score = 1;

        //Calculate the score
        while (k > 0) {
            int[] top = processingQueue.poll();
            int num = top[0];
            int idx = top[1];

            long operation = Math.min((long) k, numOfSubarrays[idx]);

            score = (score * power(num, operation)) % MOD;

            k -= operation;
        }
        
        return (int) score;
    }

    private long power(long base, long exponent) {
        long res = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1)
                res = (res * base) % MOD;
            
            base = (base * base) % MOD;

            exponent /= 2;
        }

        return res;
    }
}