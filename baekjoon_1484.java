import java.util.*;
import java.io.*;

public class baekjoon_1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 2;    // 아예 2부터 시작 (1부터는 의미 x)
        List<Integer> list = new ArrayList<>();

        while (end < G) {
            int temp = end * end - start * start;  // 배열 제거해 메모리 낭비 줄임

            if (temp == G) {
                list.add(end);
            }

            if (temp >= G) {  // 결과값 도출 부분을 따로 빼주어 분기 줄임
                start++;
            } else {
                end++;
            }

        }

        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int num : list) {
                System.out.println(num);
            }
        }
    }
}
