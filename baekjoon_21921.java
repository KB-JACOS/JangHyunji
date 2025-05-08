import java.util.*;
import java.io.*;

public class baekjoon_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 0;
        int cnt = 0;
        int len = 0;

				// 초깃값 세팅
        for (int i = 0; i < X; i++) {
            len += arr[i];
        }
        maxLen = len;  // 필수
        cnt++;         // 필수 

        // 슬라이딩 윈도우
        for (int i = 0; i < N - X; i++) {
            len += arr[i+X] - arr[i];

            if (len == maxLen) cnt++;
            else if (len > maxLen) {
                maxLen = len;
                cnt = 1;
            }
        }

        if (maxLen == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxLen);
            System.out.println(cnt);
        }
    }
}