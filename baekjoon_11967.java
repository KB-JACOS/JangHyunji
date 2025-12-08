import java.util.*;
import java.io.*;

public class baekjoon_11967 {
	static List<int[]>[][] rooms;
	static boolean[][] isLightsOn;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;
	static int isOn;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		rooms = new ArrayList[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				rooms[i][j] = new ArrayList<>();
			}
		}
		isLightsOn = new boolean[N+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			rooms[x][y].add(new int[]{a, b});
		}

		isOn = 1;
		bfs();

		System.out.println(isOn);
	}

	static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][N + 1];

		q.offer(new int[]{1, 1});
		isLightsOn[1][1] = true;
		visited[1][1] = true;

		boolean flag = false;	// 새로 불 킨 곳이 있는지

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int[] next : rooms[cur[0]][cur[1]]) {
				// 불이 off -> on
				if (!isLightsOn[next[0]][next[1]]) {
					isLightsOn[next[0]][next[1]] = true;
					isOn++;
					flag = true;
				}
			}

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + cur[0];
				int nc = dc[i] + cur[1];

				if (nr <  1 || nr > N || nc < 1 || nc > N) continue;
				if (visited[nr][nc] || !isLightsOn[nr][nc]) continue;

				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}

		if (flag) {
			bfs();
		}
	}
}