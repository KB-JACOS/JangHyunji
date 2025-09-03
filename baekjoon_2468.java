import java.io.*;
import java.util.*;

public class baekjoon_2468 {
	static int[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxDepth = Integer.MIN_VALUE;

		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxDepth = Math.max(maxDepth, board[i][j]);
			}
		}

		int res = Integer.MIN_VALUE;
		for (int i = 2; i < maxDepth; i++) {
			int eachDepthRes = bfs(i, N);
			if (eachDepthRes == 0) break;
			res = Math.max(res, eachDepthRes);
		}

		System.out.println(res);
	}

	static int bfs(int depth, int N) {
		boolean[][] visited = new boolean[N][N];
		Deque<int[]> q = new ArrayDeque<>();
		int islandCnt = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c] && board[r][c] >= depth) {
					islandCnt++;
					q.offer(new int[] {r, c});
					visited[r][c] = true;

					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int cr = cur[0];
						int cc = cur[1];

						for (int i = 0; i < 4; i++) {
							int nr = cr + dr[i];
							int nc = cc + dc[i];

							if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
							if (visited[nr][nc]) continue;
							if (board[nr][nc] < depth) continue;

							q.offer(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
					}
				}
			}
		}

		return islandCnt;
	}
}
