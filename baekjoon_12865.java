import java.util.*;
import java.io.*;

public class baekjoon_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] pack = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pack[i][0] = Integer.parseInt(st.nextToken());	// W
			pack[i][1] = Integer.parseInt(st.nextToken());	// V
		}

		int[] dp = new int[K + 1];
		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			int w = pack[i][0];
			int v = pack[i][1];

			for (int j = K; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j - w] + v);
			}
		}

		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[K]);
	}
}
