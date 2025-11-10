import java.util.*;
import java.io.*;

public class baekjoon_4485 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int idx = 1;

		while (true) {
			int size = Integer.parseInt(br.readLine());
			if (size == 0) break;

			int[][] board = new int[size][size];
			int[][] res = new int[size][size];

			for (int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					res[i][j] = INF;
				}
			}

			int result = dijstra(size, board, res);
			sb.append(String.format("Problem %d: %d\n", idx, result));
			idx++;
		}

		System.out.println(sb.toString());
	}

	static int dijstra(int size, int[][] board, int[][] res) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2] - b[2]);
		pq.offer(new int[]{0, 0, board[0][0]});

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int cost = cur[2];

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + r;
				int nc = dc[i] + c;

				if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
				if (res[nr][nc] <= board[nr][nc] + cost) continue;		// = 없으면 메모리 초과 발생

				pq.offer(new int[] {nr, nc, cost + board[nr][nc]});
				res[nr][nc] = cost + board[nr][nc];		// 넘어오는 값과 현재 값 중에 최소값
			}
		}

		return res[size - 1][size - 1];
	}
}
