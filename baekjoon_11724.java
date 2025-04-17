import java.io.*;
import java.util.*;

public class baekjoon_11724 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        // BFS
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    static void DFS(int a) {
        if (visited[a]) {
            System.out.print(a + " ");
            return;
        }

        visited[a] = true;
        for (int i : list[a]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
