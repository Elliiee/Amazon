import java.util.HashSet;
import java.util.Set;

public class am694NumberOfDisctinctIslands {
    // X : start
    // O : out of bounds
    // U = up, D = down, R = right, L = left;
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        Set<String> set = new HashSet<>(); // to find the distinct island which is its size.
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    String path = computePath(grid, i, j, m, n, "X");
                    set.add(path);
                }
            }
        }
        return set.size();
    }

    private String computePath(int[][] grid, int i, int j, int m, int n, String direction){
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return "O";
        grid[i][j] = 0;
        String left = computePath(grid, i, j - 1, m, n, "L");
        String right = computePath(grid, i, j + 1, m, n, "R");
        String up = computePath(grid, i - 1, j, m, n, "U");
        String down = computePath(grid, i + 1, j, m, n, "D");
        return direction + left + right + up + down;
    }

    // time O(m*n) space O(m*n)
}
