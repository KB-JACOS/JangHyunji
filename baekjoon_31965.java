import java.util.*;
import java.io.*;

public class baekjoon_31965 {
	static int N, Q;
	static long[] house;
	static long[] sum;		// 누적합

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		house = new long[N + 1];
		sum = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			house[i] = Long.parseLong(st.nextToken());
			sum[i] = sum[i - 1] + house[i];
		}

		for (int i = 1; i <= Q; i++) {
			st = new StringTokenizer(br.readLine());
			long l = Integer.parseInt(st.nextToken());
			long r = Integer.parseInt(st.nextToken());

			// 좌표 범위
			int L = Arrays.binarySearch(house, l);
			L = L < 0 ? -L-1 : L;

			int R = Arrays.binarySearch(house, r);
			R = R < 0 ? -R-2 : R;

			if (L >= R) {
				sb.append("0\n");
				continue;
			} else {
				// 최대 비용 -> 구간의 양 끝일때 발생
				long maxCost = Math.max(getCost(L, L, R), getCost(R, L, R));

				// 최소 비용 -> 중간값에서 발생
				long minCost = getCost((L + R) / 2, L, R);

				sb.append(maxCost - minCost).append("\n");
			}
		}

		System.out.println(sb);
	}

	private static long getCost(int target, int l, int r) {
		long right = (sum[r] - sum[target - 1]) - (long)(house[target] * (r - target + 1));
		long left = (long) (house[target] * (target - l + 1)) - (sum[target] - sum[l - 1]);

		return right + left;
	}
}
