class Solution {
    static final int MODULO = 1_000_000_007;

    static List<List<Node>> graph;

    class Node implements Comparable<Node> {
        int num;
        long time;

        public Node(int num, long time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.time, o.time);
        }
    }

    public int countPaths(int n, int[][] roads) {
        init(n, roads);

        long[] minTimes = new long[n];
        Arrays.fill(minTimes, Long.MAX_VALUE);
        minTimes[0] = 0;

        int[] numberOfWays = new int[n];
        numberOfWays[0] = 1;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0L));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : graph.get(cur.num)) {
                long nextTime = cur.time + next.time;

                if (nextTime == minTimes[next.num]) {
                    numberOfWays[next.num] = (numberOfWays[next.num] + numberOfWays[cur.num]) % MODULO;
                }

                if (nextTime < minTimes[next.num]) {
                    minTimes[next.num] = nextTime;
                    numberOfWays[next.num] = numberOfWays[cur.num];
                    pq.add(new Node(next.num, nextTime));
                }
            }
        }

        return numberOfWays[n - 1];
    }

    public void init(int n, int[][] roads) {
        graph = new ArrayList<>();
        for (int idx = 0; idx < n; idx++)
            graph.add(new ArrayList<>());
        
        for (int[] road : roads) {
            graph.get(road[0]).add(new Node(road[1], road[2]));
            graph.get(road[1]).add(new Node(road[0], road[2]));
        }
    }
}