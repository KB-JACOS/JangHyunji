import java.io.*;
import java.util.*;

public class baekjoon_4396 {
	// 상 하 좌 우 좌상 우상 좌하 우하
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {-0, 0, -1, 1, -1, 1, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[][] mine = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				if (input.charAt(j) == '*') mine[i][j] = true;
			}
		}

		boolean[][] open = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				if (input.charAt(j) == 'x') open[i][j] = true;
			}
		}

		int[][] res = new int[N][N];
		boolean flag = false;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				flag |= (mine[r][c] && open[r][c]);

				if (!open[r][c] || mine[r][c]) continue;

				for (int k = 0; k < 8; k++) {
					int nr = dr[k] + r;
					int nc = dc[k] + c;

					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

					if (mine[nr][nc]) res[r][c] += 1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (flag && mine[r][c]) sb.append("*");
				else if (open[r][c] && !mine[r][c]) sb.append(res[r][c]);
				else sb.append(".");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}