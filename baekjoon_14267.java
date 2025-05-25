import java.io.*;
import java.util.*;

public class baekjoon_14267 {
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] dp;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];

        tree.add(new ArrayList<>());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            tree.add(new ArrayList<>());

            int node = Integer.parseInt(st.nextToken());
            if (node == -1) continue;
            tree.get(node).add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            dp[start] += weight;
        }
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(int parent) {
        for (int child : tree.get(parent)) {
            dp[child] += dp[parent];
            dfs(child);
        }
    }
}