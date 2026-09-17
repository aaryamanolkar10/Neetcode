class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int from=edge[0];
            int to=edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        boolean[] visited=new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(graph,visited,i);
                count++;
            }
        }
        return count;
    }

    private void bfs(List<List<Integer>> graph,boolean[] visited,int start){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(start);
        visited[start]=true;

        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int neighbor:graph.get(curr)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
