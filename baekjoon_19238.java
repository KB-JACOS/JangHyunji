import java.io.*;
import java.util.*;

public class baekjoon_19238 {
	static class Node {
		int passX, passY, destX, destY;
		boolean visited;

		public Node(int passX, int passY, int destX, int destY, boolean visited) {
			this.passX = passX;
			this.passY = passY;
			this.destX = destX;
			this.destY = destY;
			this.visited = visited;
		}
	}

	static int[][] maps;
	static int[][] dist;
	static int N, M, F;
	static List<Node> list;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());

		maps = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] start = new int[2];
		st = new StringTokenizer(br.readLine());
		start[0] = Integer.parseInt(st.nextToken()) - 1;
		start[1] = Integer.parseInt(st.nextToken()) - 1;

		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int passX = Integer.parseInt(st.nextToken()) - 1;
			int passY = Integer.parseInt(st.nextToken()) - 1;
			int destX = Integer.parseInt(st.nextToken()) - 1;
			int destY = Integer.parseInt(st.nextToken()) - 1;

			list.add(new Node(passX, passY, destX, destY, false));
		}

		for (int i = 0; i < M; i++) {
			getShortestPath(start[0], start[1]);

			Node passenger = nextPass();
			if (passenger == null) {
				System.out.println(-1);
				return;
			}

			int distToPass = dist[passenger.passX][passenger.passY];
			if (F < distToPass) {
				System.out.println(-1);
				return;
			}

			F -= distToPass;

			int passToDest = move(passenger.passX, passenger.passY, passenger.destX, passenger.destY);
			if (passToDest == -1 || F < passToDest) {
				System.out.println(-1);
				return;
			}

			F -= passToDest;
			F += passToDest * 2;

			start[0] = passenger.destX;
			start[1] = passenger.destY;
			passenger.visited = true;
		}

		System.out.println(F);
	}

	// 각 승객까지의 최단 거리 구하기
	static void getShortestPath(int startX, int startY) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{startX, startY});

		boolean[][] visited = new boolean[N][N];
		visited[startX][startY] = true;

		dist = new int[N][N];
		for (int[] d : dist) Arrays.fill(d, -1);
		dist[startX][startY] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + cur[0];
				int nc = dc[i] + cur[1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || maps[nr][nc] == 1 || visited[nr][nc]) continue;

				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
			}
		}
	}

	// 비교 조건 가지고 다음 승객 정하기
	static Node nextPass() {
		Node selected = null;
		int minDist = Integer.MAX_VALUE;

		for (Node next : list) {
			if (next.visited) continue;

			int curDist = dist[next.passX][next.passY];
			if (curDist == -1) continue;

			if (selected == null) {
				selected = next;
				minDist = curDist;
			} else {
				if (curDist < minDist) {		// 1단계) 최단 거리
					selected = next;
					minDist = curDist;
				} else if (curDist == minDist) {    // 2단계) 행 >> 열 번호
					if (next.passX < selected.passX || (next.passX == selected.passX && next.passY < selected.passY)) {		
						selected = next;
					}
				}
			}
		}

		return selected;
	}

	// 승객 >> 목적지 이동 거리
	static int move(int startX, int startY, int destX, int destY) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{startX, startY, 0});

		boolean[][] visited = new boolean[N][N];
		visited[startX][startY] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == destX && cur[1] == destY) return cur[2];

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + cur[0];
				int nc = dc[i] + cur[1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (maps[nr][nc] == 1 || visited[nr][nc]) continue;

				q.offer(new int[] {nr, nc, cur[2] + 1});
				visited[nr][nc] = true;
			}
		}

		return -1;
	}
}