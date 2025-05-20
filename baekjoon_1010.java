import java.io.*;
import java.util.*;

public class baekjoon_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[31][31];
        for (int i = 0; i <= 30; i++) {
            dp[0][i] = 1;   // C(m, 0) - m개 중 0개를 선택하는 경우 > 1가지
            dp[i][i] = 1;   // C(m, m) - m개 중 m개를 선택하는 경우 > 1가지
        }

        for (int i = 1; i <= 30; i++) {     // 서쪽 다리 개수
            for (int j = i + 1; j <= 30; j++) {     // 동쪽 사이트 개수는 최소 n 이상
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(dp[N][M]);
        }
    }
}