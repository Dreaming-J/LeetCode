class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt((int[] meeting) -> meeting[0])
            .thenComparingInt(meeting -> meeting[1])
        );

        int count = 0;
        int dayIdx = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] > dayIdx + 1)
                count += meeting[0] - (dayIdx + 1);
            
            if (meeting[1] > dayIdx)
                dayIdx = meeting[1];

            System.out.println(dayIdx + " " + count);
        }

        if (days > dayIdx)
            count += days - dayIdx;

        return count;
    }
}