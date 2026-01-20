import java.io.*;
import java.util.*;

public class baekjoon_2632 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);

		int[] pizza1 = new int[A];
		int sumA = 0;
		for (int i = 0; i < A; i++) {
			pizza1[i] = Integer.parseInt(br.readLine());
			sumA += pizza1[i];
		}

		int[] pizza2 = new int[B];
		int sumB = 0;
		for (int i = 0; i < B; i++) {
			pizza2[i] = Integer.parseInt(br.readLine());
			sumB += pizza2[i];
		}

		// 누적합 계산 배열
		int[] prefixSumA = new int[Math.max(sumA, size) + 1];
		int[] prefixSumB = new int[Math.max(sumB, size) + 1];

		prefixSumA[0] = prefixSumB[0] = 1;			// 하나의 조각으로 가능한 경우
		prefixSumA[sumA] = prefixSumB[sumB] = 1;		// 모든 조각을 사용하는 경우는 1가지만 존재

		count(pizza1, prefixSumA);
		count(pizza2, prefixSumB);

		// 피자A와 피자B 누적합 합이 N이라면, 만들 수 있는 조합임
		int cnt = 0;
		for (int i = 0; i <= size; i++) {
			cnt += prefixSumA[i] * prefixSumB[size - i];
		}

		System.out.println(cnt);
	}

	static void count(int[] pizza, int[] prefixSum) {
		int n = pizza.length;

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < i + n - 1; j++) {
				sum += pizza[j % n];
				prefixSum[sum]++;
			}
		}
	}
}