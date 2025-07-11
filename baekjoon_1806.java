import java.io.*;
import java.util.*;

public class baekjoon_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int sum = arr[start];

        while (start <= end) {
            if (sum >= S) {
                min = Math.min(min, end - start + 1);
                sum -= arr[start];
                start++;
            } else {
                end++;
                if (end == N) break;
                sum += arr[end];
            }
        }

        int res = min == Integer.MAX_VALUE ? 0 : min;
        System.out.println(res);
    }
}