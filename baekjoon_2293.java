import java.io.*;
import java.util.*;

public class baekjoon_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        // Arrays.sort(coins);

        int[] dp = new int[K + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {   // 동전 개수
            for (int j = 1; j <= K; j++) {  // K까지
                if (j - coins[i] >= 0) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        System.out.println(dp[K]);
    }
}