class Solution {
    public boolean validTree(int n, int[][] edges) {

        // A tree with n nodes must have n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // Start DFS from node 0
        if (!dfs(0, -1, graph, visited)) {
            return false;
        }

        // Check if every node was visited
        for (boolean node : visited) {
            if (!node) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int parent,
                         List<List<Integer>> graph,
                         boolean[] visited) {

        // Cycle detected
        if (visited[node]) {
            return false;
        }

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            // Don't go back to the node we came from
            if (neighbor == parent) {
                continue;
            }

            if (!dfs(neighbor, node, graph, visited)) {
                return false;
            }
        }

        return true;
    }
}
