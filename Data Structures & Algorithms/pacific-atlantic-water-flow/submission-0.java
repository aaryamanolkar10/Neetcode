class Solution {
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        int rows=heights.length;
        int cols=heights[0].length;

        if(heights==null || rows==0 || cols==0) return res;

        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];

        //DFS
        for(int i=0;i<cols;i++){
            dfs(heights,0,i,Integer.MIN_VALUE,pacific);
            dfs(heights,rows-1,i,Integer.MIN_VALUE,atlantic);
        }
        for(int i=0;i<rows;i++){
            dfs(heights,i,0,Integer.MIN_VALUE,pacific);
            dfs(heights,i,cols-1,Integer.MIN_VALUE,atlantic);
        }
        
        //result matrix
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public  void dfs(int[][] matrix,int i,int j,int prev,boolean[][] ocean){
        if(i<0 || j<0 || i>=ocean.length || j>=ocean[0].length)return;
        if(matrix[i][j]<prev || ocean[i][j]) return;
        ocean[i][j]=true;
        for(int[] d:dir){
            dfs(matrix,i+d[0],j+d[1],matrix[i][j],ocean);
        }
    }
}
