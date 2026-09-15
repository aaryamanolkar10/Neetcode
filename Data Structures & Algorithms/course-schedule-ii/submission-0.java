class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // maintain a adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // add to inDegree
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        // add courses with 0  prerequisites to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // BFS
        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;
            for (int next : graph.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0)
                    queue.offer(next);
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return order;
    }
}
