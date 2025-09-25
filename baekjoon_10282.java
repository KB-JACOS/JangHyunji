import java.io.*;
import java.util.*;

public class baekjoon_10282 {
    static final int INF = 1_000_000_000;

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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<List<Node>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new Node(a, s));
            }

            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.offer(new Node(c, 0));
            int[] dist = new int[n+1];
            Arrays.fill(dist, INF);
            dist[c] = 0;

            while (!queue.isEmpty()) {
                Node cur = queue.poll();

                if (dist[cur.index] < cur.weight) continue;

                for (Node next : graph.get(cur.index)) {
                    int tempDist = dist[cur.index] + next.weight;
                    if (tempDist < dist[next.index]) {
                        dist[next.index] = tempDist;
                        queue.offer(new Node(next.index, tempDist));
                    }
                }
            }

            int max = 0;
            int count = 0;
            for (int x : dist) {
                if (x == INF) continue;
                count++;
                max = Math.max(max, x);
            }
            sb.append(count).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
}