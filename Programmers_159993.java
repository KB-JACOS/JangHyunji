import java.util.*;

class Programmers_159993 {
    char[][] board;
    int[] start, end, lever;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int rowLen, colLen;
    
    public int solution(String[] maps) {
        rowLen = maps.length;
        colLen = maps[0].length();
        board = new char[rowLen][colLen];
        
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                board[i][j] = maps[i].charAt(j);
                if (board[i][j] == 'S') {
                    start = new int[]{i, j};
                } else if (board[i][j] == 'E') {
                    end = new int[]{i, j};
                } else if (board[i][j] == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }
        
        int resFirst = bfs(start, lever);
        if (resFirst == -1) {
            return -1;
        } 
        
        board[lever[0]][lever[1]] = '.';
        int resSecond =bfs(lever, end);
        if (resSecond == -1) {
            return -1;
        }
        return resFirst+resSecond;    
    }
    
    int bfs(int[] from, int[] to) {
        int[][] dist = new int[rowLen][colLen];
        for (int[] row : dist) Arrays.fill(row, -1);

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(from);
        dist[from[0]][from[1]] = 0;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (0 <= nx && nx < rowLen && 0 <= ny && ny < colLen) {
                    if (dist[nx][ny] == -1 && board[nx][ny] != 'X') {
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        if (nx == to[0] && ny == to[1]) {
                            return dist[nx][ny];
                        }
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}