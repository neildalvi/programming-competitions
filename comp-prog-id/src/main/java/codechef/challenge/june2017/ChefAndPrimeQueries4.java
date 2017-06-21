package codechef.challenge.june2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ChefAndPrimeQueries4 {
	private static final int _1000001 = 1001;
	static boolean[] primes = new boolean[_1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer>[] sum = new HashMap[1000001];
		int[] tmpsum1 = new int[1000001];
		int[] tmpsum2 = new int[1000001];
		for (int i = 0; i < sum.length; i++) {
			sum[i] = new HashMap<Integer, Integer>();
		}
		int n = Integer.parseInt(br.readLine().trim());
		primes[1] = true;
		int[] a = new int[n + 1];
		int[] b = new int[n + 1];
		String[] words = br.readLine().split(" ");
		for (int i = 1; i < a.length; i++) {
			a[i] = Integer.parseInt(words[i - 1]);
			b[i] = a[i];
		}
		for (int i = 2; i <= _1000001 - 1; i++) {
			if (primes[i]) {
				continue;
			}
			tmpsum1 = tmpsum2;
			tmpsum2 = new int[1000001];
			for (int j = 1; j < b.length; j++) {
				if (b[j] == 1) {
					tmpsum2[j] = tmpsum2[j - 1] + tmpsum1[j] - tmpsum1[j - 1];
					if (tmpsum1[j] != tmpsum1[j - 1]) {
						sum[j].put(i, tmpsum2[j]);
					}
					continue;
				}
				int count = 0;
				while (b[j] % i == 0) {
					b[j] /= i;
					count++;
				}
				tmpsum2[j] = count + tmpsum1[j] - tmpsum1[j - 1] + tmpsum2[j - 1];
				if (count > 0) {
					sum[j].put(i, tmpsum2[j]);
				}
			}
			for (int j = i + i; j < _1000001; j += i) {
				primes[j] = true;
			}
		}

		/*StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 12; i++) {
			System.out.println(i + "  " + sum[i].toString());
		}*/

		int q = Integer.parseInt(br.readLine().trim());

		while (--q >= 0) {
			words = br.readLine().split(" ");
			int l = Integer.parseInt(words[0]);
			int r = Integer.parseInt(words[1]);
			int x = Integer.parseInt(words[2]);
			int y = Integer.parseInt(words[3]);

			int end = 0;
			while (r >= 0 && !sum[r].containsKey(y)) {
				r--;
			}
			if (r != 0) {
				end = sum[r].get(y);
			}
			int start = 0;
			--l;
			--x;
			while (l >= 0 && !sum[l].containsKey(x)) {
				l--;
			}
			if (l != 0) {
				end = sum[r].get(y);
			}

			System.out.println(end - start);
		}

	}

}
