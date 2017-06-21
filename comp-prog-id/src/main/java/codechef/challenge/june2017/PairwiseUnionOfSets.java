package codechef.challenge.june2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairwiseUnionOfSets {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			String[] words = br.readLine().trim().split(" ");
			int n = Integer.parseInt(words[0]);
			int k = Integer.parseInt(words[1]);
			BigInteger[] hash = new BigInteger[n];
			for (int j = 0; j < n; j++) {
				boolean[] visited = new boolean[k + 1];
				words = br.readLine().trim().split(" ");
				BigInteger result = BigInteger.ONE;
				for (int i = 1; i < visited.length; i++) {
					int input = Integer.parseInt(words[i - 1]);
					if (!visited[input]) {
						result = result.multiply(new BigInteger(words[i - 1]).add(BigInteger.ONE));
						visited[input] = true;
					}
				}
				hash[j] = result;
			}
			int count = 0;
			BigInteger target = calcTarget(k);
			for (int i = 0; i < n; i++) {
				if (hash[i].equals(target)) {
					count += n - i - 1;
					continue;
				}
				for (int j = i + 1; j < n; j++) {
					BigInteger gcd;
					if (hash[i].compareTo(hash[j]) > 0) {
						gcd = calcGCD(hash[j], hash[i]);
					} else {
						gcd = calcGCD(hash[i], hash[j]);
					}
					BigInteger calc = hash[i].multiply(hash[j]).divide(gcd);
					if (calc.equals(target)) {
						count++;
					}
				}
			}
			System.out.println(count);

		}
	}

	public static BigInteger calcGCD(BigInteger a, BigInteger b) {
		if (a.equals(BigInteger.ZERO)) {
			return b;
		}
		return calcGCD(b.mod(a), a);
	}

	private static BigInteger calcTarget(int k) {
		BigInteger result = BigInteger.ONE;
		BigInteger fact = BigInteger.ONE;
		for (int i = 1; i <= k; i++) {
			fact = fact.add(BigInteger.ONE);
			result = result.multiply(fact);
		}
		return result;
	}
}
