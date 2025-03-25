class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        PriorityQueue<int[]> vertical = new PriorityQueue<>(
                Comparator.comparingInt((int[] o) -> o[0])
                    .thenComparingInt(o -> o[2])
            );
        PriorityQueue<int[]> horizontal = new PriorityQueue<>(
                Comparator.comparingInt((int[] o) -> o[1])
                    .thenComparingInt(o -> o[3])
            );
        

        for (int[] rectangle : rectangles) {
            vertical.add(rectangle);
            horizontal.add(rectangle);
        }
        
        int verticalIdx = vertical.poll()[2];
        int verticalCutSize = 0;
        while (!vertical.isEmpty()) {
            int[] rectangle = vertical.poll();

            if (rectangle[0] >= verticalIdx) {
                verticalCutSize++;
                verticalIdx = rectangle[2];
            }

            if (rectangle[0] <= verticalIdx && verticalIdx <= rectangle[2]) {
                verticalIdx = rectangle[2];
            }
        }

        if (verticalCutSize >= 2)
            return true;
        
        int horizontalIdx = horizontal.poll()[3];
        int horizontalCutSize = 0;
        while (!horizontal.isEmpty()) {
            int[] rectangle = horizontal.poll();

            if (rectangle[1] >= horizontalIdx) {
                horizontalCutSize++;
                horizontalIdx = rectangle[3];
            }

            if (rectangle[1] <= horizontalIdx && horizontalIdx <= rectangle[3]) {
                horizontalIdx = rectangle[3];
            }
        }

        if (horizontalCutSize >= 2)
            return true;

        return false;
    }
}