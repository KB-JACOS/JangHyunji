import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class baekjoon_16496 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<String> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr.add(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String aPlusB = s1 + s2;
				String bPlusA = s2 + s1;

				BigDecimal a = new BigDecimal(aPlusB);
				BigDecimal b = new BigDecimal(bPlusA);

				if (a.compareTo(b) < 0) {	// a < b
					return 1;
				} else if (a.compareTo(b) > 0) {	// a > b
					return -1;
				} else {	// a == b
					return 0;
				}
			}
		});
		// System.out.println(arr);

		if (arr.get(0).equals("0")) {
			System.out.println(0);
			return;
		}

		for (String s : arr) {
			sb.append(s);
		}

		System.out.println(new BigDecimal(sb.toString()));
	}
}
