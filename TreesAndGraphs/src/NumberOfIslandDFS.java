/*
Number of Islands
Given a 2d grid map of '1's (land) and '0' (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslandDFS {
    public void dfs(char[][] grid, int r, int c){
        int numRow = grid.length;
        int numColumn = grid[0].length;

        if (r < 0 || c < 0 || r > numRow || c > numColumn || grid[r][c] == '0'){
            return ;
        }

        grid[r][c] = '0'; // mark as visited
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }

        int numRow = grid.length;
        int numColumn = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < numRow; r++){
            for (int c = 0; c < numColumn; c++){
                if(grid[r][c] == '1'){
                    num_islands++;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }
}
