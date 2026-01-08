import java.io.*;
import java.util.*;

public class baekjoon_2513 {
	static int answer = 0;
	static int N, K, S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());	// 단지 수
		K = Integer.parseInt(st.nextToken());	// 정원
		S = Integer.parseInt(st.nextToken());	// 학교

		List<int[]> aptA = new ArrayList<>();
		List<int[]> aptB = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int location = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());

			if (location < S) {
				aptA.add(new int[] {location, people});
			} else {
				aptB.add(new int[] {location, people});
			}
		}

		aptA.sort((a, b) -> Integer.compare(a[0], b[0]));	// 오름차순
		aptB.sort((a, b) -> Integer.compare(b[0], a[0]));	// 내림차순

		getDist(aptA);
		getDist(aptB);

		System.out.println(answer);
	}

	static void getDist(List<int[]> apt) {
		int idx = 0;

		while (idx < apt.size()) {
			int curLimit = K;
			int farthest = apt.get(idx)[0];

			answer += Math.abs(S - farthest) * 2;		// 거리는 어차피 제일 먼 아파트를 기준으로 계산됨

			while (idx < apt.size() && curLimit > 0) {
				int student = apt.get(idx)[1];

				if (student <= curLimit) {
					curLimit -= student;
					idx++;
				} else {
					apt.get(idx)[1] -= curLimit;
					curLimit = 0;
				}
			}
		}
	}
}
