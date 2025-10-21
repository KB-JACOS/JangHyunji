import java.util.*;
import java.io.*;

public class baekjoon_12904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder T = new StringBuilder(br.readLine());

		while (T.length() > S.length()) {
			if (T.charAt(T.length() - 1) == 'A') {
				T.deleteCharAt(T.length() - 1);
			} else {
				T.deleteCharAt(T.length() - 1);
				T.reverse();
			}
		}

		if (S.equals(T.toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
