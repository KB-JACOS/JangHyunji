import java.util.*;
import java.io.*;

public class baekjoon_1717 {
	static int[] parent;
	static int[] size;

	static int find(int n) {
		if (parent[n] != n) {
			parent[n] = find(parent[n]);
		}
		return parent[n];
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) return;

		if (size[x] < size[y]) {
			int temp = x;
			x = y;
			y = temp;
		}
		
		parent[y] = x;
		size[x] += size[y];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		size = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			parent[i] = i;
			size[i] = 1;    // 초기값: 반드시 1
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int numOfCase = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (numOfCase == 0) {
				union(a, b);
			} else {
				if (find(a) == find(b)) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}

		System.out.println(sb.toString());
	}
}
