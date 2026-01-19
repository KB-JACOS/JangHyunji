import java.io.*;
import java.util.*;

public class swea_1249 {
	static int[][] map;
	static int N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		int idx = 1;

		while (idx <= T) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}

			int res = dijkstra();
			String str = "#" + idx + " " + res;
			sb.append(str).append("\n");
			idx++;
		}

		System.out.println(sb);
	}

	static int dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		boolean[][] visited = new boolean[N][N];

		pq.offer(new int[] {0, 0, 0});
		visited[0][0] = true;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (cur[0] == N - 1 && cur[1] == N - 1) return cur[2];

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + cur[0];
				int nc = dc[i] + cur[1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc]) continue;

				pq.offer(new int[]{nr, nc, cur[2] + map[nr][nc]});
				visited[nr][nc] = true;
			}
		}

		return 0;
	}
}