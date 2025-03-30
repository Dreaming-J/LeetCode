class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int idx = 0; idx < s.length(); idx++)
            map.put(s.charAt(idx), idx);
        
        List<Integer> partitionSizes = new ArrayList<>();
        int partitionStart = 0;
        int partitionEnd = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            partitionEnd = Math.max(map.get(s.charAt(idx)), partitionEnd);

            if (idx == partitionEnd) {
                partitionSizes.add(idx - partitionStart + 1);
                partitionStart = idx + 1;
            }
        }

        return partitionSizes;
    }
}