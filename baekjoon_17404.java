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

		int res = Integer.MAX_VALUE;
		int[][] dp = new int[N + 1][4];

		for (int start = 1; start <= 3; start++) {
			for (int i = 1; i <= N; i++) {
				Arrays.fill(dp[i], INF);
			}
			dp[1][start] = cost[1][start];

			for (int i = 2; i <= N; i++) {
				dp[i][R] = Math.min(dp[i - 1][G], dp[i - 1][B]) + cost[i][R];
				dp[i][G] = Math.min(dp[i - 1][R], dp[i - 1][B]) + cost[i][G];
				dp[i][B] = Math.min(dp[i - 1][R], dp[i - 1][G]) + cost[i][B];
			}

			for (int i = 1; i <= 3; i++) {
				if (start != i) {
					res = Math.min(res, dp[N][i]);
				}
			}
		}
        
		System.out.println(res);
	}
}