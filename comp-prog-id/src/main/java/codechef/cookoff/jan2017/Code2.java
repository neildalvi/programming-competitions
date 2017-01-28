package codechef.cookoff.jan2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Long c = Long.parseLong(st.nextToken());
			Long d = Long.parseLong(st.nextToken());
			Long l = Long.parseLong(st.nextToken());
			System.out.println(solve(c, d, l) ? "yes" : "no");
		}
	}

	public static boolean solve(long c, long d, long l) {
		return false;
	}
}
