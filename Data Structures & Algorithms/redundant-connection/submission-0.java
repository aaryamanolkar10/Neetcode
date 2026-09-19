class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n + 1];

            // Check if u and v are already connected
            if (dfs(u, v, graph, visited)) {
                return edge;
            }

            // No cycle, so add the edge
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }

    private boolean dfs(int curr, int target,
                        List<List<Integer>> graph,
                        boolean[] visited) {

        if (curr == target) {
            return true;
        }

        visited[curr] = true;

        for (int neighbor : graph.get(curr)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, target, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}