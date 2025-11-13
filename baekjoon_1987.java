import java.io.*;
import java.util.*;

public class baekjoon_1987 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static int maxDist = 1;
	static int R, C;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = input.charAt(j);
			}
		}

		boolean[] visited = new boolean[26];
		visited[board[0][0] - 'A'] = true;
		dfs(0, 0, 1, visited);

		System.out.println(maxDist);
	}

	static void dfs(int r, int c, int cnt, boolean[] visited) {
		maxDist = Math.max(maxDist, cnt);

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

			char nextChar = board[nr][nc];
			if (!visited[nextChar - 'A']) {
				visited[nextChar - 'A'] = true;
				dfs(nr, nc, cnt + 1, visited);
				visited[nextChar - 'A'] = false;
			}
		}
	}
}