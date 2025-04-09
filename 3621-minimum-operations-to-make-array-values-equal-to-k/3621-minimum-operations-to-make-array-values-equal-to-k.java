class Solution {
    public int minOperations(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums)
            .boxed()
            .distinct()
            .sorted(Collections.reverseOrder())
            .toList();

        int listSize = list.size();
        int minNum = list.get(listSize - 1);
        
        if (minNum < k)
            return -1;
        else if (minNum > k)
            return listSize;
        else
            return listSize - 1;
    }
}