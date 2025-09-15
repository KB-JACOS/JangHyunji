import java.util.*;
import java.io.*;

/**
 * BOJ 20191
 * Gold 2
 * 줄임말
 */

public class baekjoon_20191 {
	static Map<Character, List<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();

		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);

			map.putIfAbsent(c, new ArrayList<>());
			map.get(c).add(i);
		}

		int res = 1;
		int idx = -1;

		for (int i = 0; i < S.length(); i++) {
			char target = S.charAt(i);

			if (!map.containsKey(target)) {
				System.out.println(-1);
				return;
			}

			List<Integer> targetList = map.get(target);
			int nextPos = binarySearch(idx, targetList);

			if (nextPos == targetList.size()) {        // 못찾음
				res++;
				idx = targetList.get(0);
			} else {
				idx = targetList.get(nextPos);
			}
		}

		System.out.println(res);
	}

	static int binarySearch(int target, List<Integer> targetList) {
		int left = 0;
		int right = targetList.size();

		while (left < right) {
			int mid = (left + right) / 2;
			if (targetList.get(mid) > target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}
}
