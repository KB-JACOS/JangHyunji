import java.io.*;
import java.util.*;

public class baekjoon_2461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] clazz = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				clazz[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(clazz[i]);
		}

		int[] idx = new int[N];

		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(clazz[a][idx[a]], clazz[b][idx[b]]));
		int curMax = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			pq.offer(i);
			curMax = Math.max(curMax, clazz[i][0]);
		}

		int res = Integer.MAX_VALUE;

		while (true) {
			int minRow = pq.poll();
			int curMin = clazz[minRow][idx[minRow]];

			res = Math.min(res, curMax - curMin);

			idx[minRow]++;
			if (idx[minRow] == M) break;

			curMax = Math.max(curMax, clazz[minRow][idx[minRow]]);
			pq.offer(minRow);
		}

		System.out.println(res);
	}
}