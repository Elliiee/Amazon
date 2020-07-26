import java.util.ArrayDeque;
import java.util.Queue;

public class am909SnakesAndLadders {
    public int snakesAndLadders(int[][] board){
        if (board == null || board.length == 0) return 0;
        int n = board.length;
        boolean[] visited = new boolean[n*n + 1]; // save the number starts from 1
        int min = n*n;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        int moves = 0;
        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                int cur = q.poll();
                if (cur == n * n){
                    min = Math.min(min, moves);
                }

                for (int j = 1; j <= 6; j++){ // number of moves up to 6
                    int num = cur + j; // number after the moves
                    if (num > n * n) break;
                    int row = n - (num - 1)/ n - 1;
                    int col = (n - row) % 2 != 0 ? (num - 1) % n : n - (num - 1) % n - 1;

                    if(!visited[num]){
                        visited[num] = true;

                        if (board[row][col] == -1){
                            q.offer(num);
                        } else {
                            q.offer(board[row][col]);
                        }
                    }
                }
            }
            moves++;
        }
        return min == n * n ? -1 : min;
    }
}
