import java.io.*;
import java.util.*;

public class baekjoon_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long start = 1;
        long end = arr[K-1];
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (int i : arr) {
                sum += i / mid;
            }

            if (sum >= N) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
