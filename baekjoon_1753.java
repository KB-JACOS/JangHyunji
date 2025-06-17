import java.io.*;
import java.util.*;

public class baekjoon_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int INF = 1_000_000_000;

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;
        queue.offer(new Node(K, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.dist > dist[cur.index]) continue;;

            for (Node next : graph.get(cur.index)) {
                int tempDist = dist[cur.index] + next.dist;
                if (tempDist < dist[next.index]) {
                    dist[next.index] = tempDist;
                    queue.offer(new Node(next.index, tempDist));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] != INF) sb.append(dist[i]).append("\n");
            else sb.append("INF").append("\n");
        }

        System.out.println(sb.toString());
    }

    static class Node implements Comparable<Node> {
        int index, dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}