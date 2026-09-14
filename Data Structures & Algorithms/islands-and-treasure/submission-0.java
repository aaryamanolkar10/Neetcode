class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Put all treasures in queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int r = cell[0];
            int c = cell[1];

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                // Outside grid
                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                // Not an empty land cell
                if (grid[nr][nc] != Integer.MAX_VALUE)
                    continue;

                // Set distance
                grid[nr][nc] = grid[r][c] + 1;

                q.add(new int[]{nr, nc});
            }
        }
    }
}