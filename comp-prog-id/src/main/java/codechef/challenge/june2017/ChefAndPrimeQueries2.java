package codechef.challenge.june2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ChefAndPrimeQueries2 {
	private static final int _1000001 = 1000001;
	static boolean[] primes = new boolean[_1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer>[] sum = new HashMap[1000001];
		int[] tmpsum1 = new int[1000001];
		int[] tmpsum2 = new int[1000001];
		for (int i = 0; i < sum.length; i++) {
			sum[i] = new HashMap<Integer, Integer>();
		}
		primes[1] = true;
		int previousPrime = -1;
		for (int i = 2; i <= _1000001 - 1; i++) {
			if (primes[i]) {
				continue;
			}
			int count = 1;
			int prevSum = 0;
			tmpsum1 = tmpsum2;
			tmpsum2 = new int[1000001];
			tmpsum2[i] = count + tmpsum1[i];
			sum[i].put(i, tmpsum2[i]);
			if (i > 1000) {
				previousPrime = i;
				continue;
			}
			int exp = i * i;
			while (exp < _1000001) {
				count++;
				sum[exp].put(i, count);
				exp = exp * i;
			}
			int total = tmpsum2[i];
			for (int j = i + 1, k = i + i; j < _1000001; j++) {
				if (j == k) {
					if (sum[j].containsKey(i)) {
						total = total + sum[j].get(i);
						tmpsum2[j] = total + tmpsum1[j] - tmpsum1[j - 1];
					} else {
						tmpsum2[j] = ++total + tmpsum1[j] - tmpsum1[j - 1];
					}
					sum[j].put(i, tmpsum2[j]);
					k += i;
					primes[j] = true;
				}
				total = total + tmpsum1[j] - tmpsum1[j - 1];
				tmpsum2[j] = total;
			}
			previousPrime = i;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 12; i++) {
			System.out.println(i + "  " + sum[i].toString());
		}

		int n = Integer.parseInt(br.readLine().trim());
		String[] words = br.readLine().split(" ");
		int[] a = new int[n + 1];

		for (int i = 1; i <= words.length; i++) {
			a[i] = Integer.parseInt(words[i - 1]);
		}

		int q = Integer.parseInt(br.readLine().trim());

		while (--q >= 0) {
			words = br.readLine().split(" ");
			int l = Integer.parseInt(words[0]);
			int r = Integer.parseInt(words[1]);
			int x = Integer.parseInt(words[2]);
			int y = Integer.parseInt(words[3]);

			// System.out.println(calc(primes, mul, recur, a, l, r, x, y));
		}

	}

}
