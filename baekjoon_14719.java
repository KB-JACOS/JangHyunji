import java.util.*;
import java.io.*;

public class baekjoon_14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] blocks = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}

		int res = 0;

		for (int idx = 1; idx < W - 1; idx++) {
			int leftMax = 0;
			int rightMax = 0;

			for (int i = 0; i <= idx; i++) {
				leftMax = Math.max(leftMax, blocks[i]);
			}

			for (int i = idx; i < W; i++) {
				rightMax = Math.max(rightMax, blocks[i]);
			}

			res += (Math.min(leftMax, rightMax) - blocks[idx]);
		}

		System.out.println(res);
	}
}
