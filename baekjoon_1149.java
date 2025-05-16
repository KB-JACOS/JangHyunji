import java.io.*;
import java.util.*;

public class rename {
    static int[][] board;
    static int[][] dp;
    static int R = 0, G = 1, B = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        board = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 26 40 83 -> 26
         * (40+49=89) (26+60=86) (26+57=83) -> 83
         * (83+13=96) (83+89=172) (86+99=185) => 96
         */

        // 최소값 구하기
        int min = 0;
        for (int j = 0; j < 3; j++) {
            if (min > board[0][j]) {
                min = board[0][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = board[0][i];
        }

        for (int i = 1; i < N; i++) {
            dp[i][R] = Math.min(dp[i-1][G], dp[i-1][B]) + board[i][R];
            dp[i][G] = Math.min(dp[i-1][R], dp[i-1][B]) + board[i][G];
            dp[i][B] = Math.min(dp[i-1][R], dp[i-1][G]) + board[i][B];
        }

        int res = Math.min(dp[N - 1][R], Math.min(dp[N - 1][G], dp[N - 1][B]));
        System.out.println("res = " + res);
    }
}