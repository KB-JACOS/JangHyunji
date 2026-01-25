import java.io.*;
import java.util.*;

public class baekjoon_2578 {
	static int[][] board;
	static int bingo = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] called = new int[25];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 5; j++) {
				called[(5 * i) + j] = Integer.parseInt(st.nextToken());
			}
		}

		int res = -1;
		for (int i = 0; i < 5 * 5; i++) {
			int[] pos = getLoc(called[i]);
			isBingo(pos[0], pos[1]);
			if (bingo >= 3) {
				res = i + 1;
				break;
			}
		}

		System.out.println(res);
	}

	static int[] getLoc(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == num) {
					board[i][j] = 0;
					return new int[] {i, j};
				}
			}
		}

		return new int[] {};
	}

	static void isBingo(int r, int c) {
		// col
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (board[i][c] == 0) cnt++;
		}
		if (cnt == 5) bingo++;

		// row
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (board[r][i] == 0) cnt++;
		}
		if (cnt == 5) bingo++;

		// cross
		if (r == c) {
			cnt = 0;
			for (int i = 0; i < 5; i++) {
				if (board[i][i] == 0) cnt++;
			}
			
			if (cnt == 5) bingo++;
		}

		if (r + c == (5 - 1)) {
			cnt = 0;
			for (int i = 5 - 1; i >= 0; i--) {
				if (board[i][(5 - 1) - i] == 0) cnt++;
			}
			
			if (cnt == 5) bingo++;
		}
	}
}