class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> numbers = new ArrayList<>();
        int result = 0;

        for (int[] line : grid) {
            for (int number : line)
                numbers.add(number);
        }

        Collections.sort(numbers);

        int length = numbers.size();
        int finalCommonNumber = numbers.get(length / 2);

        for (int number : numbers) {
            if (number % x != finalCommonNumber % x)
                return -1;

            result += Math.abs(finalCommonNumber - number) / x;
        }

        return result;
    }
}