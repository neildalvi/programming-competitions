package codechef.lunchtime.jan2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Code2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			int n = Integer.parseInt(br.readLine());
			String[] words;
			BigInteger[] d = new BigInteger[n];
			BigInteger px, py, x = BigInteger.ZERO, y = BigInteger.ZERO;
			for (int i = 0; i < n; i++) {
				words = br.readLine().split(" ");
				px = x;
				py = y;
				x = new BigInteger(words[0]);
				y = new BigInteger(words[1]);
				if (i != 0) {
					BigInteger dx = x.subtract(px);
					BigInteger dy = y.subtract(py);
					d[i] = (dx.multiply(dx)).add(dy.multiply(dy));
				}
			}
			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				
			}
			System.out.println(solve());
		}
	}

	public static boolean solve() {
		return false;
	}
}
