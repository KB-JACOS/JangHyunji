import java.io.*;
import java.util.*;

public class baekjoon_1234 {
	static int N, R, G, B;
	static long[][][][] dp = new long[11][101][101][101];
	static long[][] comb = new long[11][11];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		// 조합 미리 계산
		for (int i = 0; i <= 10; i++) {
			comb[i][0] = comb[i][i] = 1;
			for (int j = 1; j < i; j++) {
				comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
			}
		}
		// System.out.println(Arrays.deepToString(comb));

		// DP 배열 -1로 초기화
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= R; j++) {
				for (int k = 0; k <= G; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		System.out.println(dfs(1, R, G, B));
	}

	static long dfs(int level, int r, int g, int b) {
		if (level > N) return 1;

		// 이미 계산된 값이 있으면 반환
		if (dp[level][r][g][b] != -1) return dp[level][r][g][b];

		long ans = 0;

		// 1색
		if (r >= level) ans += dfs(level + 1, r - level, g, b);
		if (g >= level) ans += dfs(level + 1, r, g - level, b);
		if (b >= level) ans += dfs(level + 1, r, g, b - level);

		// 2색
		if (level % 2 == 0) {
			int half = level / 2;
			long ways = comb[level][half];
			if (r >= half && g >= half) ans += ways * dfs(level + 1, r - half, g - half, b);
			if (r >= half && b >= half) ans += ways * dfs(level + 1, r - half, g, b - half);
			if (g >= half && b >= half) ans += ways * dfs(level + 1, r, g - half, b - half);
		}

		// 3색
		if (level % 3 == 0) {
			int third = level / 3;
			long ways = comb[level][third] * comb[level - third][third];
			if (r >= third && g >= third && b >= third) {
				ans += ways * dfs(level + 1, r - third, g - third, b - third);
			}
		}

		return dp[level][r][g][b] = ans;
	}
}