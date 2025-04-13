class Solution {

    public static final int MODULO = 1_000_000_007;
    public static final int EVEN_COUNT = 5;
    public static final int PRIME_COUNT = 4;

    public int countGoodNumbers(long n) {
        return (int) ((mul(EVEN_COUNT, (n + 1) / 2) * mul(PRIME_COUNT, n / 2)) % MODULO);
    }

    // Calculate x^y
    public long mul(int x, long y) {
        long ret = 1;
        long mul = x;

        while (y > 0) {
            if (y % 2 == 1) {
                ret = (ret * mul) % MODULO;
            }

            mul = (mul * mul) % MODULO;
            y /= 2;
        }

        return ret;
    }
}