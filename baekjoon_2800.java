import java.util.*;
import java.io.*;

public class baekjoon_2800 {
    static List<int[]> pairs = new ArrayList<>();
    static Deque<Integer> stack = new ArrayDeque<>();
    static Set<String> res = new TreeSet<>();   // 중복 제거 + 사전순 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // () 쌍 인덱스
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                pairs.add(new int[]{stack.pop(), i});
            }
        }

        // 비트 마스킹으로 부분집합
        int pairCount = pairs.size();
        for (int mask = 1; mask < (1 << pairCount); mask++) {   // mask = 0이면 예제 입력도 포함됨
            boolean[] check = new boolean[str.length()];

            for (int j = 0; j < pairCount; j++) {
                if ((mask & (1 << j)) != 0) {
                    int[] p = pairs.get(j);
                    // 제거할 괄호 인덱스 표시
                    check[p[0]] = true;
                    check[p[1]] = true;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < str.length(); k++) {
                if (!check[k]) sb.append(str.charAt(k));    // 제거한 괄호만 제외하고 출력에 포함
            }
            res.add(sb.toString());
        }

        for (String s : res) {
            System.out.println(s);
        }
    }
}
