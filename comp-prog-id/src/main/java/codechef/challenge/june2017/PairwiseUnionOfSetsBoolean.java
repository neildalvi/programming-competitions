package codechef.challenge.june2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairwiseUnionOfSetsBoolean {
	private static final int CONST_63 = 63;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			String[] words = br.readLine().trim().split(" ");
			int n = Integer.parseInt(words[0]);
			int k = Integer.parseInt(words[1]);
			int len0 = 1;
			if (k > CONST_63) {
				len0 = (int) Math.ceil((double)k / CONST_63);
			}
			Long[][] hash = new Long[n][len0];
			for (int j = 0; j < n; j++) {
				boolean[] visited = new boolean[k + 1];
				words = br.readLine().trim().split(" ");
				int len = Integer.parseInt(words[0]);
				for (int i = 1; i <= len; i++) {
					int tmp = Integer.parseInt(words[i]);
					visited[tmp] = true;
				}
				long temp = 0;
				int index = 0;
				for (int x = 1, y = 0; x <= k; x++, y++) {
					temp = temp << 1 | (visited[x] ? 1 : 0);
					if (y == CONST_63 - 1) {
						hash[j][index] = temp;
						index++;
					}
				}
				hash[j][index] = temp;
			}
			int count = 0;
			Long[] target = calcTarget(k, len0);
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					boolean completeUnion = true;
					for (int m = 0; m < len0; m++) {
						if (hash[i][m] != null && hash[j][m] != null && target[m] != (hash[i][m] | hash[j][m])) {
							completeUnion = false;
							break;
						}
					}
					if (completeUnion) {
						count++;
					}
				}
			}
			System.out.println(count);

		}
	}

	private static Long[] calcTarget(int k, int len) {
		Long[] result = new Long[len];
		long temp = 0;
		int index = 0;
		for (int i = 0, j = 0; i < k; i++, j++) {
			temp = temp << 1 | 0x1;
			if (j == CONST_63 - 1) {
				result[index] = temp;
				index++;
			}
		}
		result[index] = temp;
		return result;
	}
}
