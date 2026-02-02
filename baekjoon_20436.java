import java.io.*;
import java.util.*;

public class baekjoon_20436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Character, int[]> map = new HashMap<>();

		String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
		for (int r = 0; r < rows.length; r++) {
			for (int c = 0; c < rows[r].length(); c++) {
				char ch = rows[r].charAt(c);
				map.put(ch, new int[] {r, c});
			}
		}

		char[] input = br.readLine().toCharArray();

		int[] leftPos = map.get(input[0]);
		int[] rightPos = map.get(input[2]);

		String str = br.readLine();

		int res = str.length();

		for (char ch : str.toCharArray()) {
			if (isLeft(ch)) {
				int[] nextPos = map.get(ch);

				res += Math.abs(leftPos[0] - nextPos[0]) +  Math.abs(leftPos[1] - nextPos[1]);

				leftPos = nextPos;
			} else {
				int[] nextPos = map.get(ch);

				res += Math.abs(rightPos[0] - nextPos[0]) +  Math.abs(rightPos[1] - nextPos[1]);

				rightPos = nextPos;
			}
		}

		System.out.println(res);
	}

	static boolean isLeft(char ch) {
		return "qwertasdfgzxcv".indexOf(ch) != -1;
	}
}
