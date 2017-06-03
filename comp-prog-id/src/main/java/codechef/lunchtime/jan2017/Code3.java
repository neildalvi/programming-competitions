package codechef.lunchtime.jan2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			String[] words = br.readLine().split(" ");
			System.out.println(solve());
		}
	}

	public static boolean solve() {
		return false;
	}
}
