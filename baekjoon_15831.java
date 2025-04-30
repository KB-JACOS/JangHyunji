import java.util.*;
import java.io.*;

public class baekjoon_15831 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        
        int start = 0;
        int end = 0;
        int whiteCount = 0;
        int blackCnt = 0;

        int ans = 0;
        int tempLen = 0;

        while (end < N) {
            if (blackCnt > B) {
                if (str.charAt(start) == 'W') {
                    whiteCount--;
                } else {
                    blackCnt--;
                }
                start++;
                tempLen--;
            } else {
                 if (str.charAt(end) == 'W') {
                    whiteCount++;
                } else {
                     blackCnt++;
                 }
                end++;
                tempLen++;
            }

            if (blackCnt <= B && whiteCount >= W) {
                ans = Math.max(tempLen, ans);
            }
        }

        System.out.println(ans);
    }
}
