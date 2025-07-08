import java.io.*;
import java.util.*;

public class baekjoon_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] lectures = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작 시간(S)을 오름차순으로 정렬
        Arrays.sort(lectures, (a,b) -> a[0] - b[0]);

        // 우선순위 큐에 끝나는 시간(T)만 저장
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0][1]);

        for (int i = 1; i < N; i++) {
            int start = lectures[i][0];
            int end = lectures[i][1];

            if (pq.peek() <= start) {
                pq.poll();
            }
            pq.offer(end);
        }

        System.out.println(pq.size());
    }
}