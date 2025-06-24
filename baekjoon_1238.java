import java.io.*;
import java.util.*;

public class baekjoon_1238 {
    static final int INF = 1_000_000_000;
    static List<List<Node>> graph;

    static class Node implements Comparable<Node> {
        int index, weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        int maxTime = 0;
        int[] fromX = getDist(X, N);

        for (int i = 1; i <= N; i++) {
            if (i == X) continue;

            int[] toX = getDist(i, N);
            int roundTripTime = toX[X] + fromX[i];

            maxTime = Math.max(maxTime, roundTripTime);
        }

        System.out.println(maxTime);
    }

    static int[] getDist(int start, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.weight > dist[cur.index]) continue;

            for (Node next : graph.get(cur.index)) {
                int tempDist = dist[cur.index] + next.weight;

                if (tempDist < dist[next.index]) {
                    dist[next.index] = tempDist;
                    queue.offer(new Node(next.index, tempDist));
                }
            }
        }
        return dist;
    }
}