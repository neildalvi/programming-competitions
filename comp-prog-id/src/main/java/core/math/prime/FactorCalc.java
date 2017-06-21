package core.math.prime;

import java.util.ArrayList;
import java.util.List;

public class FactorCalc {

	private static final int MAXN = 1000;
	private static int[] spf;

	public static void sieve() {
		spf = new int[MAXN+1];
		spf[1] = 1;
		for (int i = 2; i <= MAXN; i++)
			spf[i] = i;
		for (int i = 4; i <= MAXN; i += 2)
			spf[i] = 2;
		for (int i = 3; i * i <= MAXN; i += 2) {
			if (spf[i] == i) {
				for (int j = i * i; j <= MAXN; j += i) {
					if (spf[j] == j)
						spf[j] = i;
				}
			}
		}
	}

	public static List<Integer> getFactors(int n) {
		List<Integer> factors = new ArrayList<>();
		while (n != 1) {
			factors.add(spf[n]);
			n /= spf[n];
		}
		return factors;
	}

	public static void main(String[] args) {
		sieve();
		System.out.println(getFactors(50));
	}
}
