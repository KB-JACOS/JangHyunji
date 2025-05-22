import java.io.*;
import java.util.*;

public class baekjoon_1074 {
    static int count;
    static int r;
    static int c;
    static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        count = 0;

        // 규칙을 활용한 풀이
        int res = rotate(r, c);
        System.out.println(res);

        // 문제가 의도한 풀이
        int t = (int) Math.pow(2, N);
        dv(0, 0, t);
    }

    // 규칙을 활용한 풀이
    public static int rotate(int r, int c) {
        if (r == 0 && c == 0) {
            return 0;
        }

        if (r % 2 == 0 && c % 2 == 0) {
            return rotate(r/2, c/2) * 4;
        }
        else if (r % 2 == 0 && c % 2 == 1) {
            return rotate(r, c-1) + 1;
        }
        else if (r % 2 == 1 && c % 2 == 0) {
            return rotate(r-1, c) +2;
        }
        else{
            return rotate(r-1, c-1) +3;
        }
    }

    // 문제가 의도한 풀이
    private static void dv(int x, int y, int size) {
        if (size == 1) {
            if (x == r && y == c) {
                System.out.println(count);
            }
            count++;
            return;
        }

        int t = size / 2;

        // 1사분면 (왼쪽 위)
        if (r < x + t && c < y + t) {
            dv(x, y, t);
        }
        // 2사분면 (오른쪽 위)
        else if (r < x + t && c >= y + t) {
            count += t * t;
            dv(x, y + t, t);
        }
        // 3사분면 (왼쪽 아래)
        else if (r >= x + t && c < y + t) {
            count += 2 * t * t;
            dv(x + t, y, t);
        }
        // 4사분면 (오른쪽 아래)
        else {
            count += 3 * t * t;
            dv(x + t, y + t, t);
        }
    }
}