import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/*
Approach 1: Breadth-First Search
Intuition
Every turn, the rotting spreads from each rotting orange to other adjacent oranges.
Initially, the rotten oranges have 'depth' 0 [as in the spanning tree of a graph],
and every time they rot a neighbor, the neighbors have 1 more depth. We want to know the largest possible depth.

Algorithm
We can use a breadth-first search to model this process.
Because we always explore nodes (oranges) with the smallest depth first,
we're guaranteed that each orange that becomes rotten does so with the lowest possible depth number.
We should also check that at the end, there are no fresh oranges left.
 */
public class RottingOranges {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid){
        int R = grid.length;
        int C = grid[0].length;

        // create a queue for all starting cells with rotten oranges
        Queue<Integer> queue = new LinkedList<>();

        // create a hash map to remember the depth
        Map<Integer, Integer> depth = new HashMap<>();

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (grid[r][c] == 2){
                    int code =  r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()){
            int code = queue.remove();
            int r = code / C;
            int c = code % C;
            for (int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dr[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row : grid){
            for (int v : row){
                if ( v == 1)
                    return -1;
            }
        }

        return ans;
    }
}
