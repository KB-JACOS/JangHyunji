import java.io.*;
import java.util.*;

public class baekjoon_2668 {
	static List<Integer> list;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		list = new ArrayList<>();
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			System.out.printf("[Main] dfs(%d, %d) 호출\n", i, i);
			dfs(i, i);		// 시작, target
			visited[i] = false;
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (int i : list) {
			System.out.println(i);
		}
	}

	static void dfs(int cur, int target) {
		if (!visited[arr[cur]]) {
			visited[arr[cur]] = true;
			System.out.printf("[DFS] dfs(%d, %d) 호출\n", arr[cur], target);
			dfs(arr[cur], target);
			visited[arr[cur]] = false;
		}

		if (arr[cur] == target) {
			list.add(target);
			System.out.printf("%d 추가\n", target);
		}
	}
}