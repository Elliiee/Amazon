public class am200NumberOfIslands {
    public int numIslands(char[][] grid){
        if (grid == null) return 0;
        int islandCount = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    // increase the count and change connected land to 0
                    islandCount++;
                    changeLandToWater(grid, i, j);
                }
            }
        }
        return islandCount;
    }

    private void changeLandToWater(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        changeLandToWater(grid, i, j + 1);
        changeLandToWater(grid, i, j - 1);
        changeLandToWater(grid, i + 1, j);
        changeLandToWater(grid, i - 1, j);
    }
}
