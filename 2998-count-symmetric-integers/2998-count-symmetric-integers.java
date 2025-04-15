class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        for (int num = low; num <= high; num++) {
            int length = (int) Math.log10(num) + 1;

            if (length % 2 != 0)
                continue;
            
            int halfSum = 0;
            int totalSum = 0;
            for (int idx = 1; idx <= length; idx++) {
                totalSum += (int) (num / Math.pow(10, idx - 1)) % 10;

                if (idx * 2 == length)
                    halfSum = totalSum;
            }

            if (halfSum * 2 == totalSum)
                ans++;
        }

        return ans;
    }
}