import java.io.*;
import java.util.*;

public class baekjoon_2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] top = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}

		Stack<int[]> stack = new Stack<>();
		int[] res = new int[N + 1];

		for (int i = N; i > 0; i--) {
			if (stack.isEmpty()) {
				stack.push(new int[]{top[i], i});	// height, idx + 1
			} else {
				while (!stack.isEmpty() && stack.peek()[0] < top[i]) {
					int[] pop = stack.pop();

					res[pop[1]] = i;
				}

				stack.push(new int[]{top[i], i});
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(res[i]).append(" ");
		}

		System.out.println(sb);
	}
}