import java.io.*;
import java.util.*;

public class baekjoon_7576 {
    static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int M = Integer.parseInt(st.nextToken());
		final int N = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][M];
		int[][] day = new int[N][M];
		for (int r = 0; r < N; r++) Arrays.fill(day[r], -1);

		Deque<int[]> q = new ArrayDeque<>();

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				int v = Integer.parseInt(st.nextToken());
				board[r][c]= v;
				if (v == 1) {	// 익은 놈
					day[r][c] = 0;	// 0일부터 시작
					q.offer(new int[] {r, c});
				}
			}
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (board[nr][nc] == -1) continue;	// 빈 칸
				if (day[nr][nc] != -1) continue;	// 이미 방문

				day[nr][nc] = day[r][c] + 1;
				q.offer(new int[] {nr, nc});
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == -1) continue;
				if (day[i][j] == -1) {
					System.out.println(-1);
					return;
				}
				ans = Math.max(ans, day[i][j]);
			}
		}
		System.out.println(ans);
	}
}
