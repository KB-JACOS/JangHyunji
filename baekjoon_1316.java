import java.io.*;
import java.util.*;

public class baekjoon_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = N;

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            boolean isSame = false;
            cnt = getCount(arr, cnt);
        }
        System.out.println(cnt);
    }

    public static int getCount(char[] arr, int cnt) {
        HashSet<Character> set = new HashSet<>();
        boolean isSame = false;
        set.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            isSame = (arr[i-1] == arr[i]);

            if (!isSame) {
                if (set.contains(arr[i])) {
                    cnt--;
                    return cnt;
                }
                set.add(arr[i]);
            }
        }
        return cnt;
    }
}