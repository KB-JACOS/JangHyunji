import java.util.*;

class Programmers_67259 {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        int N = board.length;
        int[][][] dp = new int[N][N][4];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        
        bfs(N, board, dp);
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, dp[N-1][N-1][i]);
        }
        
        return res;
    }
    
    void bfs(int N, int[][] board, int[][][] dp) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, -1, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                // if (nr == (N - 1) && nc == (N - 1)) break;
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                
                int newCost;
                
                if (cur[2] == -1) {     // 시작점 -> 방향 x
                    newCost = cur[3] + 100;
                } else {
                    newCost = cur[3] + (cur[2] == i ? 100 : 600);   // 코너는 100 + 500 = 600 추가됨
                }
                     
                if (board[nr][nc] == 0 && newCost < dp[nr][nc][i]) {
                    dp[nr][nc][i] = newCost;
                    q.offer(new int[]{nr, nc, i, newCost});
                }
            }
        }
    }
}