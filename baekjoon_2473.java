import java.util.*;
import java.io.*;

public class baekjoon_2473 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] nums = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(nums);

		long[] res = new long[3];
		long min = Long.MAX_VALUE;

		for (int start = 0; start < N - 2; start++) {
			int left = start + 1;
			int right = N - 1;

			while (left < right) {
				long sum = nums[start] + nums[left] + nums[right];
				if (min > Math.abs(sum)) {
					min = Math.abs(sum);
					res[0] = nums[start];
					res[1] = nums[left];
					res[2] = nums[right];
				}

				if (sum == 0) break;
				else if (sum < 0) left++;
				else right--;
			}
		}

		for (long r : res) {
			System.out.print(r + " ");
		}
	}
}