import java.io.*;
import java.util.*;

public class baekjoon_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        char[] str = (br.readLine()).toCharArray();
        for(char c : str) {
            left.offer(c);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "L" -> {
                    if (!left.isEmpty()) {
                        right.offer(left.pollLast());
                    }
                }
                case "D" -> {
                    if (!right.isEmpty()) {
                        left.offer(right.pollLast());
                    }
                }
                case "B" -> {
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                }
                case "P" -> {
                    char addStr = input[1].charAt(0);
                    left.offer(addStr);
                }
            }
            // System.out.println(i + ", left: " + left + ", right: " +right);
        }

        while (!left.isEmpty()) {
            bw.write(left.poll());
        }
        while (!right.isEmpty()) {
            bw.write(right.pollLast());
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
