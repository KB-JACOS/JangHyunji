import java.util.*;
import java.io.*;

public class baekjoon_17404 {
	static final int R = 1;
	static final int G = 2;
	static final int B = 3;
	static final int INF = 9999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] cost = new int[N+1][4];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] dp = new int[N + 1][4][4];
		for (int start = 1; start <= 3; start++) {
			for (int c = 1; c <= 3; c++) {
				if (start == c) dp[1][c][start] = cost[1][c];
				else dp[1][c][start] = INF;
			}
		}

		for (int i = 2; i <= N; i++) {
			for (int c = 1; c <= 3; c++) {
				for (int start = 1; start <= 3; start++) {
					if (c == R) dp[i][R][start] = Math.min(dp[i-1][G][start], dp[i-1][B][start]) + cost[i][R];
					else if (c == G) dp[i][G][start] = Math.min(dp[i - 1][R][start], dp[i - 1][B][start]) + cost[i][G];
					else dp[i][B][start] = Math.min(dp[i - 1][R][start], dp[i - 1][G][start]) + cost[i][B];
				}
			}
		}

		int res = INF;
		for (int start = 1; start <= 3; start++) {
			for (int c = 1; c <= 3; c++) {
				if (start != c) {
					res = Math.min(res, dp[N][c][start]);
				}
			}
		}

		System.out.println(res);
	}
}
