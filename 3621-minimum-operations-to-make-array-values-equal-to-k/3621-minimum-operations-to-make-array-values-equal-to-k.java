class Solution {
    public int minOperations(int[] nums, int k) {
        Long bit1 = 0L;
        Long bit2 = 0L;

        for (int num : nums) {
            if (num > 50)
                bit2 |= 1L << (num - 50);
            else
                bit1 |= 1L << num;
        }

        int size = Long.bitCount(bit1) + Long.bitCount(bit2);
        int minValue = bit1 != 0 ? Long.numberOfTrailingZeros(bit1) : Long.numberOfTrailingZeros(bit2) + 50;
        
        if (minValue < k)
            return -1;
        else if (minValue > k)
            return size;
        else
            return size - 1;
    }
}