class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        int size = nums.size();

        for (int num : nums)
            secondMap.put(num, secondMap.getOrDefault(num, 0) + 1);
        
        for (int idx = 0; idx < size; idx++) {
            int num = nums.get(idx);

            secondMap.put(num, secondMap.get(num) - 1);
            firstMap.put(num, firstMap.getOrDefault(num, 0) + 1);

            if (firstMap.get(num) * 2 > idx + 1 && secondMap.get(num) * 2 > size - (idx + 1))
                return idx;
        }

        return -1;
    }
}