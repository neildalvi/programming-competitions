package codechef.challenge.jan2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CatsAndDogs {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Long c = Long.parseLong(st.nextToken());
			Long d = Long.parseLong(st.nextToken());
			Long l = Long.parseLong(st.nextToken());
			System.out.println(validateCount(c, d, l) ? "yes" : "no");
		}
	}

	public static boolean validateCount(long c, long d, long l) {
		long term = d + c - l / 4;
		if ((c != 0 || d != 0) && l == 0) {
			return false;
		}
		if (l % 4 == 0 && term >= 0 && term <= 2 * d && term <= c) {
			return true;
		}
		return false;
	}
}
