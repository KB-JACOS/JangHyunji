import java.io.*;

public class baekjoon_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2];
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], dp[i + T[i]] + P[i]);
            }
        }
        System.out.println(dp[1]);
    }
}
