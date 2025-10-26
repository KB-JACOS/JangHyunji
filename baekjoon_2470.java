import java.util.*;
import java.io.*;

public class baekjoon_2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] nums = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(nums);

		long[] res = new long[2];
		int left = 0;
		int right = N - 1;
		long min = Integer.MAX_VALUE;

		while (left < right) {
			long sum = nums[left] + nums[right];

			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				res[0] = nums[left];
				res[1] = nums[right];
			}

			if (sum == 0) break;
			else if (sum < 0) left++;
			else right--;
		}

		for (long r : res) {
			System.out.print(r + " ");
		}
	}
}
