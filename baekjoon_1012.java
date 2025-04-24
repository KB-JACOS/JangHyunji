import java.util.*;
import java.io.*;

public class baekjoon_1012 {
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int x, y;


        for (int i = 0; i < T; i++) {
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            board = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            for (int k = 0; k < N; k++) {
                for (int l = 0; l < M; l++) {
                    if (!visited[k][l] && board[k][l] == 1) {
                        visited[k][l] = true;
                        bfs(k, l);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int x, int y) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + point[0];
                int ny = dy[i] + point[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (board[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}