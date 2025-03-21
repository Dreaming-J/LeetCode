class Solution {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Deque<String> queue = new ArrayDeque<>();

        for (String supply : supplies) {
            graph.put(supply, new ArrayList<>());
            inDegree.put(supply, 0);
            queue.add(supply);
        }

        for (int idx = 0; idx < recipes.length; idx++) {
            graph.putIfAbsent(recipes[idx], new ArrayList<>());
            
            for (String ingredient : ingredients.get(idx)) {
                graph.putIfAbsent(ingredient, new ArrayList<>());
                graph.get(ingredient).add(recipes[idx]);
                inDegree.put(recipes[idx], inDegree.getOrDefault(recipes[idx], 0) + 1);
            }
        }

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            for (String next : graph.get(cur)) {
                if (inDegree.put(next, inDegree.get(next) - 1) == 1) {
                    answer.add(next);
                    queue.add(next);
                }
            }
        }

        return answer;
    }
}