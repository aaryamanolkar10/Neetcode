class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        Queue<int[]> q=new LinkedList<>();

        int fresh=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int minutes=0;

        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};

        //BFS
        while(!q.isEmpty() && fresh>0){
            int size=q.size();

            for(int i=0;i<size;i++){
                int[] current=q.poll();
                
                int r=current[0];
                int c=current[1];

                for(int[] d:directions){
                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr<0 || nc<0 || nr>=rows || nc>=cols) continue;

                    if(grid[nr][nc]!=1)continue;

                    grid[nr][nc]=2;
                    fresh--;
                    q.add(new int[]{nr,nc});
                }
            }
            minutes++;
        }
        if(fresh>0) return -1;
        return minutes;
    }
}
