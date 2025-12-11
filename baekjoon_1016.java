import java.io.*;
import java.util.*;

public class baekjoon_1016 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());

		Set<Long> visited = new HashSet<>();
		for (long i = 2; i * i <= max; i++) {
			long start = (min % (i * i) == 0) ? min / (i * i) : min / (i * i) + 1;
			long end = max / (i * i);

			for (long j = start; j <= end; j++) {
				visited.add(i * i * j);
			}
		}

		System.out.println((max - min + 1) - visited.size());
	}
}