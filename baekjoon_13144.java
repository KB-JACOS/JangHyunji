import java.io.*;
import java.util.*;

public class baekjoon_13144 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long res = 0;
		int left = 0, right = 0;
		int[] visited = new int[100001];	// 윈도우 길이

		while (right < N) {
				if (visited[arr[right]] == 0) {  // 중복 없음
				visited[arr[right]]++;  // 방문 처리
				res += (right - left + 1);  // 끝이 right인 부분까지의 부분수열 개수
				right++;
			} else {	// 중복 감지
				while (visited[arr[right]] > 0) {	// 새로 들어오려는 값의 visited 값이 0이 될 때까지 반복
					visited[arr[left]]--;
					left++;
				}
			}
		}

		System.out.println(res);
	}
}
