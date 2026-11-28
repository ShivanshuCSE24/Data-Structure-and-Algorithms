class Solution {
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1; 

        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i<m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        return bfs(grid, q, fresh);
    }
    public int bfs(int[][] grid, Queue<int[]> q, int fresh){
        int n = grid.length;
        int m = grid[0].length;
        int t = 0;
        int d[][] = {{-1,0}, {1,0},{0,-1}, {0,1}};

        while(!q.isEmpty() && fresh > 0){
            int currRot = q.size();

            for(int i = 0; i<currRot; i++){
                
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];

                for(int j = 0; j < d.length; j++){

                    int nr = r + d[j][0];
                    int nc = c + d[j][1];

                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;

                        q.add(new int[]{nr,nc});
                    }
                }
            }
            t++; 
        }
        if(fresh == 0){
            return t;
        }else{
            return -1;
        }
    }
}