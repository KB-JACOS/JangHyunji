import java.util.*;
import java.io.*;

public class baekjoon_4195 {
	static int[] parent;
	static int[] depth;
	static Map<String, Integer> map;

	static int find(int n) {
		if (parent[n] != n) {
			parent[n] = find(parent[n]);		// 대표자 찾을때까지
		}

		return parent[n];
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {		// 합쳐지지 않은 경우
			// depth가 더 큰 쪽을 부모로
			if (depth[x] > depth[y]) {
				int temp = y;
				y = x;
				x = temp;
			}
			parent[x] = y;	// x 대표자를 y로
			depth[y] += depth[x];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int F = Integer.parseInt(br.readLine());

			parent = new int[F * 2 + 1];
			depth = new int[F * 2 + 1];
			map = new HashMap<>();

			int idx = 1;	// 고유 ID, 1부터 시작
			for (int i = 0; i < F; i++) {
				String[] friends = br.readLine().split(" ");

				for (int j = 0; j < 2; j++) {
					if (!map.containsKey(friends[j])) {	// 처음 등록되는 경우만
						map.put(friends[j], idx);
						parent[idx] = idx;		// Union-Find: 초기에는 자신이 부모
						depth[idx] = 1;			// 네트워크 크기: 초기에는 1명
						idx++;
					}
				}

				union(map.get(friends[0]), map.get(friends[1]));
				int root = find(map.get(friends[0]));
				sb.append(depth[root]).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
