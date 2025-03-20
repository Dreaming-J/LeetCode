class Solution {
    private int[] parents, minCost;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parents = new int[n];
        Arrays.setAll(parents, idx -> idx);
        minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        for (int[] edge : edges) {
            minCost[find(edge[0])] &= minCost[find(edge[1])] & edge[2];
            
            parents[find(edge[1])] = find(edge[0]);
        }

        int[] answer = new int[query.length];

        for (int idx = 0; idx < query.length; idx++) {
            if (find(query[idx][0]) == find(query[idx][1]))
                answer[idx] = minCost[find(query[idx][0])];
            else
                answer[idx] = -1;
        }

        return answer;
    }

    private int find(int element) {
        if (parents[element] == element)
            return element;
        
        return parents[element] = find(parents[element]);
    }
}