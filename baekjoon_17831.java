import java.io.*;
import java.util.*;

public class baekjoon_17831 {
	static List<Integer>[] list;
	static int[] skill;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		list = new ArrayList[N+ 1];
		for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			list[parent].add(i + 1);
		}

		skill = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			skill[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N + 1][2];
		dfs(1);

		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}

	static void dfs(int node) {
		int sum = 0;		// 자식의 최댓값 누적
		int bestBonus = 0;	// 자식을 멘티로 선택했을 때 가장 큰 이득

		if (list[node].isEmpty()) return;

		for (int child : list[node]) {
			dfs(child);
			sum += Math.max(dp[child][0], dp[child][1]);

			int newSyn = skill[node] * skill[child];
			// 자식의 best 선택값과 해당 자식과의 시너지의 차이 구하기
			int diff = dp[child][1] + newSyn - Math.max(dp[child][0], dp[child][1]);
			bestBonus = Math.max(bestBonus, diff);
		}

		dp[node][1] = sum;		// 멘토 X
		dp[node][0] = sum + bestBonus;	// 멘토 O
	}
}