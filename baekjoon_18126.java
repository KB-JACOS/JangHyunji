import java.util.*;
import java.io.*;

class Node {
	int nextRoom;
	long dist;

	public Node(int next, long dist) {
		this.nextRoom = next;
		this.dist = dist;
	}
}

public class baekjoon_18126 {
	static List<List<Node>> graph = new ArrayList<>();
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		System.out.println(bfs(1));;
	}

	static long bfs(int start) {
		boolean[] visited = new boolean[N+1];
		Deque<Node> queue = new ArrayDeque<>();
		long maxDist = 0;

		queue.offer(new Node(start, 0));
		visited[start] = true;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			maxDist = Math.max(maxDist, cur.dist);

			for (Node next : graph.get(cur.nextRoom)) {
				if (!visited[next.nextRoom]) {
					visited[next.nextRoom] = true;
					queue.offer(new Node(next.nextRoom, cur.dist + next.dist));
				}
			}
		}

		return maxDist;
	}
}
