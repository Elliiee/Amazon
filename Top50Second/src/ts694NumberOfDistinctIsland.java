import java.util.HashSet;
import java.util.Set;

public class ts694NumberOfDistinctIsland {
    int[][] directions = {{1, 0}, {-1, 0}, {-1, 0}, {1,0}};

    public int numDistinctIslands(int[][] grid){
        Set<String> set = new HashSet<>();
        int res = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, 0, 0, sb);
                    if (!set.contains(sb.toString())){
                        res++;
                    }
                    set.add(sb.toString());
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int r, int c, int xpos, int ypos, StringBuilder sb){
        sb.append(xpos + "" + ypos);
        for(int[] d : directions){
            int nr = r + d[0];
            int nc = c + d[1];
            int nxpos = xpos + d[0];
            int nypos = ypos + d[1];
            if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc]== 0)
                continue;
            dfs(grid, nr, nc, nxpos, nypos, sb);
        }
    }
}
