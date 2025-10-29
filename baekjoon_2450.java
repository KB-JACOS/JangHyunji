import java.io.*;
import java.util.*;

public class baekjoon_2450 {
	static int[][] perm = {
		{1, 2, 3}, {1, 3, 2},
		{2, 1, 3}, {2, 3, 1},
		{3, 1, 2}, {3, 2, 1}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] board = new int[N + 1];
		int[] num = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			board[i] = Integer.parseInt(st.nextToken());
			num[board[i]]++;
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			int[][] diff = new int[4][4];
			int[] curPerm = perm[i];

			int idx = 1;
			for (int j = 1; j <= num[curPerm[0]]; j++) {
				diff[curPerm[0]][board[idx]]++;
				idx++;
			}

			for (int j = 1; j <= num[curPerm[1]]; j++) {
				diff[curPerm[1]][board[idx]]++;
				idx++;
			}

			for (int j = 1; j <= num[curPerm[2]]; j++) {
				diff[curPerm[2]][board[idx]]++;
				idx++;
			}

			res = Math.min(res, diff[curPerm[0]][curPerm[1]] + diff[curPerm[0]][curPerm[2]]
				+ Math.max(diff[curPerm[1]][curPerm[2]], diff[curPerm[2]][curPerm[1]]));
		}

		System.out.println(res);
	}
}
