import java.io.*;

public class baekjoon_1802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            boolean isCorrect = true;
            String str = br.readLine();
            int len = str.length();
            int[] input = new int[len];
            for (int j = 0; j < len; j++) {
                input[j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }

            while (isCorrect && len > 1) {
                for (int j = 0; j < len / 2; j++) {
                    if (input[j] + input[len - 1 - j] != 1) {
                        isCorrect = false;
                        break;
                    }
                }
                len /= 2;
                System.out.println("len = " + len);
            }
            System.out.println(isCorrect ? "YES" : "NO");
        }
    }
}
