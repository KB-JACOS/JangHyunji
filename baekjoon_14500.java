import java.io.*;
import java.util.*;

public class baekjoon_14500 {
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int max1 = 0;
    static int max2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        // 입력 읽기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 칸을 시작점으로 DFS와 체크 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                DFS(0, board[i][j], i, j);
                visited[i][j] = false;
                check(i, j);
            }
        }
        System.out.println(Math.max(max1, max2));
    }

    // 일반 테트로미노 모양을 DFS로 탐색 (시작점이 있으므로 깊이는 3까지)
    static void DFS(int depth, int sum, int curX, int curY) {
        if (depth == 3) {
            max1 = Math.max(max1, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = curX + dx[i];
            int ny = curY + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                DFS(depth+1, sum + board[nx][ny], nx, ny);
                visited[nx][ny] = false;
            }
        }
    }

    // ㅗ 모양 테트로미노 체크
    static void check(int curX, int curY) {
        // 4가지 방향 중 하나를 빼고 나머지 3칸을 더함
        for (int i = 0; i < 4; i++) {
            int sum = board[curX][curY];
            boolean valid = true;

            for (int j = 0; j < 4; j++) {
                if (i == j) continue;   // 모양을 만들기 위해 한 칸은 뺌

                int nx = curX + dx[j];
                int ny = curY + dy[j];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    valid = false;
                    break;
                }
                sum += board[nx][ny];
            }
            if (valid) {
                max2 = Math.max(sum, max2);
            }
        }
    }
}