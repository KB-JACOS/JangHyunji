import java.io.*;
import java.util.*;

public class baekjoon_1260 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for (ArrayList<Integer> list : arr) {
            if (list != null) {
                Collections.sort(list);
            }
        }

        DFS(V);
        sb.append("\n");

        Arrays.fill(visited, false);
        BFS(V);

        br.close();
        System.out.println(sb);
    }

    static void DFS(int idx) {
        if (visited[idx]) {
            return;
        }

        visited[idx] = true;
        sb.append(idx).append(" ");

        for (int node : arr[idx]) {
            if (!visited[node]) {
                DFS(node);
            }
        }
    }

    static void BFS(int start) {
        Deque<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int i = 0; i < arr[node].size(); i++) {
                int temp = arr[node].get(i);
                if (!visited[temp]) {
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }
    }
}