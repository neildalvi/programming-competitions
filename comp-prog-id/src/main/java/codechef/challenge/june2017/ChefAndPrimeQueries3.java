package codechef.challenge.june2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChefAndPrimeQueries3 {
	private static final int _1000001 = 1000001;
	static boolean[] primes = new boolean[_1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[][] sum = new int[78499][n + 1];
		int[] primesLoc = new int[78499];
		primes[1] = true;
		int[] a = new int[n + 1];
		int[] b = new int[n + 1];
		String[] words = br.readLine().split(" ");
		for (int i = 1; i < a.length; i++) {
			a[i] = Integer.parseInt(words[i - 1]);
			b[i] = a[i];
		}
		Map<Integer, Integer> map = calc(sum, b, primesLoc);

		int q = Integer.parseInt(br.readLine().trim());

		while (--q >= 0) {
			words = br.readLine().split(" ");
			int l = Integer.parseInt(words[0]);
			int r = Integer.parseInt(words[1]);
			int x = Integer.parseInt(words[2]);
			int y = Integer.parseInt(words[3]);

			int result = answerQuery(sum, primesLoc, map, l, r, x, y);
			System.out.println(result);
		}

	}

	public static int answerQuery(int[][] sum, int[] primesLoc, Map<Integer, Integer> map, int l, int r, int x, int y) {
		if (x == 1 && y == 1) {
			return 0;
		}

		int ydash = Arrays.binarySearch(primesLoc, y);
		boolean xflg = false, yflg = false;
		if (ydash < 0) {
			ydash = -(ydash + 1);
			ydash--;
			yflg = true;
		}
		int xdash = Arrays.binarySearch(primesLoc, x);
		if (xdash < 0) {
			xdash = -(xdash + 1);
			//xdash--;
			xflg = true;
		}
		if (xdash == 0) {
			xdash = 1;
		}
		int yprime = map.get(primesLoc[ydash]);
		Integer xprime = map.get(primesLoc[xdash]);
		if (xprime == null) {
			xprime = 1;
		}
		if (xflg && yflg && xdash == ydash) {
			return 0;
		}
		return sum[yprime][r] - sum[xprime - 1][r] - sum[yprime][l - 1] + sum[xprime - 1][l - 1];

		/*
		 * if (xdash == 0) { xdash = 2; }
		 */
		// if (l == r && xdash == ydash) {
		// l--;
		// } else if (xdash == 0) {
		// xdash = ydash;
		// l--;
		// } else if (l == r && xdash != ydash) {
		// l--;
		// } else if (xdash == ydash && l != r) {
		// l--;
		// } else {
		// l--;
		// //xdash--;
		// }
		//
		// int end = 0;
		// if (map.containsKey(primesLoc[ydash])) {
		// end = sum[map.get(primesLoc[ydash])][r];
		// }
		// int start = 0;
		// if (map.containsKey(primesLoc[xdash])) {
		// start = sum[map.get(primesLoc[xdash])][l];
		// }
		// int result = end - start;
		// /*
		// * System.out.println(xdash); System.out.println(ydash); for (int i =
		// 0;
		// * i < 10; i++) { System.out.print(primesLoc[i]); }
		// */
		// return result;
	}

	public static Map<Integer, Integer> calc(int[][] sum, int[] b, int[] primesLoc) {
		int primeIndex = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 2; i <= _1000001 - 1; i++) {
			if (primes[i]) {
				continue;
			}
			primeIndex++;
			primesLoc[primeIndex] = i;

			map.put(i, primeIndex);
			for (int j = 1; j < b.length; j++) {
				if (b[j] == 1) {
					sum[primeIndex][j] = sum[primeIndex][j - 1] + sum[primeIndex - 1][j] - sum[primeIndex - 1][j - 1];
					continue;
				}
				int count = 0;
				while (b[j] % i == 0) {
					b[j] /= i;
					count++;
				}
				sum[primeIndex][j] = count + sum[primeIndex][j - 1] + sum[primeIndex - 1][j]
						- sum[primeIndex - 1][j - 1];
			}
			for (int j = i + i; j < _1000001; j += i) {
				primes[j] = true;
			}
		}
		return map;
	}

}
