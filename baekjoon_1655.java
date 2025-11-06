import java.util.*;
import java.io.*;

public class baekjoon_1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> head = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> tail = new PriorityQueue<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());

			if (head.size() == tail.size()) {
				head.offer(input);
			} else {
				tail.offer(input);
			}

			int h = head.peek();	// 앞에서 가장 큰거
			int t = tail.peek();	// 뒤에서 가장 작은거

			if (h > t) {
				int hToT = head.poll();
				int tToH = tail.poll();

				head.offer(tToH);
				tail.offer(hToT);
			}

			// sb에 추가하기
			sb.append(head.peek()).append("\n");
		}

		System.out.println(sb.toString());
	}
}