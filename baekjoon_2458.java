import java.io.*;
import java.util.*;

public class baekjoon_2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] shorterThan = new ArrayList[N + 1];
        List<Integer>[] tallerThan = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            tallerThan[i] = new ArrayList<>();
            shorterThan[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tallerThan[a].add(b);    // a보다 큰 사람들
            shorterThan[b].add(a);   // b보다 작은 사람들
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (check(shorterThan, i, N) + check(tallerThan, i, N) == N - 1) count++;
        }

        System.out.println(count);
    }

    static private int check(List<Integer>[] list, int start, int N) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int cnt = 0;

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer next : list[cur]) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}