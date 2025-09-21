import java.io.*;

public class baekjoon_14495 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[] fibo = new long[117];
		fibo[1] = 1;
		fibo[2] = 1;
		fibo[3] = 1;

		int n = Integer.parseInt(br.readLine());
		if (n <= 3) {
			System.out.println(fibo[n]);
			return;
		}

		for (int i = 4; i <= n; i++) {
			fibo[i] = fibo[i-1] + fibo[i-3];
		}

		System.out.println(fibo[n]);
	}
}
