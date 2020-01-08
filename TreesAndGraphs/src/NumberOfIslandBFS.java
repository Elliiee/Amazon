import java.util.LinkedList;
import java.util.Queue;

/*
Number of Islands
Given a 2d grid map of '1's (land) and '0' (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */
/*
Linear scan the 2d grid map, if a node contains a '1',
then it is a root node that triggers a BFS.
Put it into a queue and set its value as '0' to mark as visited node.
Iteratively search the neighbors of enqueued nodes until the queue becomes empty.
 */
public class NumberOfIslandBFS {
    public int numIslands(char[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }

        int numRow = grid.length;
        int numColumn = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < numRow; r++){
            for (int c = 0; c < numColumn; c++){
                if (grid[r][c] == '1'){
                    num_islands++;
                    grid[r][c] = '0'; // mark as visited

                    Queue<Integer>  neighbors = new LinkedList<>();
                    neighbors.add(r * numColumn + c);

                    while (!neighbors.isEmpty()){
                        int id = neighbors.remove();
                        int row = id / numColumn;
                        int col = id % numColumn;

                        if (row - 1 >= 0 && grid[row-1][col] == '1'){
                            neighbors.add((row-1) * numColumn + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < numRow && grid[row+1][col] == '1'){
                            neighbors.add((row+1) * numColumn + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1'){
                            neighbors.add(row * numColumn + col - 1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 > numColumn && grid[row][col+1] == '1'){
                            neighbors.add(row * numColumn + col + 1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }

        }
        return num_islands;
    }
}
