class Solution {

    public static final int[][] DELTAS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public class Cell implements Comparable<Cell> {
        int row, col, maxValue;

        public Cell(int row, int col, int maxValue) {
            this.row = row;
            this.col = col;
            this.maxValue = maxValue;
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(this.maxValue, o.maxValue);
        }
    }
    
    public int[] maxPoints(int[][] grid, int[] queries) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int totalCells = rowCount * colCount;
        int queryCount = queries.length;
        int[] answer = new int[queryCount];

        int[] thresholdForMaxPoints = new int[totalCells + 1];
        int[][] minValueToReach = new int[rowCount][colCount];
        for (int[] row : minValueToReach)
            Arrays.fill(row, Integer.MAX_VALUE);
        minValueToReach[0][0] = grid[0][0];

        PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        minHeap.add(new Cell(0, 0, grid[0][0]));
        int visitedCells = 0;

        while (!minHeap.isEmpty()) {
            Cell cur = minHeap.poll();

            thresholdForMaxPoints[++visitedCells] = cur.maxValue;

            for (int[] delta : DELTAS) {
                int nextRow = cur.row + delta[0];
                int nextCol = cur.col + delta[1];

                if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount || minValueToReach[nextRow][nextCol] != Integer.MAX_VALUE)
                    continue;
                
                minValueToReach[nextRow][nextCol] = Math.max(cur.maxValue, grid[nextRow][nextCol]);

                minHeap.add(new Cell(nextRow, nextCol, minValueToReach[nextRow][nextCol]));
            }
        }

        for (int idx = 0; idx < queryCount; idx++) {
            int threshold = queries[idx];
            int left = 0;
            int right = totalCells;

            while (left < right) {
                int mid = (left + right + 1) / 2;

                if (thresholdForMaxPoints[mid] < threshold)
                    left = mid;
                else
                    right = mid - 1;
            }

            answer[idx] = left;
        }

        return answer;
    }
}