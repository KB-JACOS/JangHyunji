    import java.io.*;
    import java.util.*;

    public class baekjoon_1326 {
        static int[] arr;
        static int N;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int res = bfs(a, b);
            System.out.println(res);
        }

        static int bfs(int start, int end) {
            boolean[] visited = new boolean[N];
            visited[start] = true;

            Deque<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{start, 0});

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int idx = cur[0];  // 인덱스
                int multiple = arr[idx];

                if (idx == end) return cur[1];

                for (int i = idx; i < N; i+=multiple) {
                    if (!visited[i]) {
                        queue.offer(new int[]{i, cur[1] + 1});
                        visited[i] = true;
                    }
                }

                for (int i = idx; i >= 0; i-=multiple) {
                    if (!visited[i]) {
                        queue.offer(new int[]{i, cur[1] + 1});
                        visited[i] = true;
                    }
                }
            }

            return -1;
        }
    }