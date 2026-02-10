import java.io.*;
import java.util.*;

public class baekjoon_2631 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] line = new int[N];

		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[N];
		Arrays.fill(dp, 1);

		int max = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (line[i] > line[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(N - max);
	}
}