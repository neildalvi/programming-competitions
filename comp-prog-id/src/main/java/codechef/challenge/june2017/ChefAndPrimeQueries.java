package codechef.challenge.june2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChefAndPrimeQueries {
	private static final int _1000001 = 1000001;
	static boolean[] primes = new boolean[_1000001];
	static int[] mul = new int[_1000001];
	static int[][] recur = new int[_1000001][2];
	private static boolean preprocessingComplete;
	private static Map<String, Integer> precompute = new HashMap<String, Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		primes = new boolean[_1000001];
		mul = new int[_1000001];
		Arrays.fill(mul, 1);
		recur = new int[_1000001][2];
		if (!preprocessingComplete) {
			preprocess(primes, mul, recur);
			preprocessingComplete = true;
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

			System.out.println(calc(primes, mul, recur, a, l, r, x, y));
		}

	}

	public static int calc(boolean[] primes, int[] mul, int[][] recur, int[] a, int l, int r, int x, int y) {
		int totalCount = 0;
		for (int i = x; i <= y; i++) {

			if (!primes[i]) {
				for (int j = l; j <= r; j++) {
					if (precompute.containsKey(a[j] + "_" + i)) {
						totalCount += precompute.get(a[j] + "_" + i);
						continue;
					}
					int count = 0;
					if (a[j] == i) {
						count++;
					} else if (recur[a[j]][0] == i) {
						count += recur[a[j]][1];
					} else {
						if (mul[a[j]] != 0 && mul[a[j]] % i == 0) {
							int tmp2 = a[j] / mul[a[j]];
							count++;
							if (recur[tmp2][0] == i) {
								count += recur[tmp2][1];
							} else {
								while (tmp2 % i == 0) {
									tmp2 /= i;
									count++;
								}
							}
						}
					}
					precompute.put(a[j] + "_" + i, count);
					totalCount += count;
				}
			}
		}
		return totalCount;
	}

	public static void preprocess(boolean[] primes, int[] mul, int[][] recur) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		primes[1] = true;

		for (int i = 2; i <= _1000001 - 1; i++) {
			if (primes[i]) {
				continue;
			}
			int recurence = i * i;
			int count = 2;
			for (int j = i * 2; j < _1000001; j += i) {
				primes[j] = true;
				mul[j] *= i;
				if (recurence == j) {
					recur[j][0] = i;
					recur[j][1] = count;
					count++;
					recurence = recurence * i;
				}
			}
		}
	}

}
