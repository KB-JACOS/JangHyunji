import java.io.*;
import java.util.*;

public class baekjoon_2178 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] arr;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        // 입력 값 배열에 저장
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        bfs(0, 0);    // 시작점으로 탐색 시작
        System.out.println(arr[N-1][M-1]);
    }

    static void bfs(int x, int y) {
        Deque<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (visited[nx][ny] || arr[nx][ny] == 0) {
                    continue;
                }

                q.offer(new Pair(nx, ny));
                arr[nx][ny] = arr[p.x][p.y] + 1;
                visited[nx][ny] = true;
                System.out.printf("이동한 칸: (%d, %d), arr[%d][%d] = %d\n", nx, ny, nx, ny, arr[nx][ny]);
            }
        }
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
