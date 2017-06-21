package codechef.challenge.june2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triplets {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (--t >= 0) {
			String[] words = br.readLine().split(" ");
			int p = Integer.parseInt(words[0]);
			int q = Integer.parseInt(words[1]);
			int r = Integer.parseInt(words[2]);

			List<Long> P = new ArrayList<Long>(p);
			List<Long> Q = new ArrayList<Long>(q);
			List<Long> R = new ArrayList<Long>(r);

			words = br.readLine().split(" ");
			for (String word : words) {
				P.add(Long.parseLong(word));
			}

			words = br.readLine().split(" ");
			for (String word : words) {
				Q.add(Long.parseLong(word));
			}

			words = br.readLine().split(" ");
			for (String word : words) {
				R.add(Long.parseLong(word));
			}

			long result = calc(p, q, r, P, Q, R);

			System.out.println(result);
		}
	}

	public static long calc(int p, int q, int r, List<Long> P, List<Long> Q, List<Long> R) {

		if (P.size() == 0 || Q.size() == 0 || R.size() == 0) {
			return 0;
		}

		Collections.sort(P);
		Collections.sort(Q);
		Collections.sort(R);

		BigInteger MOD = new BigInteger("1000000007");
		long MODLONG = 1000000007L;

		long sum = R.get(0);
		long[] RSum = new long[R.size()];
		RSum[0] = sum;
		for (int i = 1; i < R.size(); i++) {
			RSum[i] = R.get(i) + sum;
			sum = RSum[i];
		}

		sum = P.get(0);
		long[] PSum = new long[P.size()];
		PSum[0] = sum;
		for (int i = 1; i < PSum.length; i++) {
			PSum[i] = P.get(i) + sum;
			sum = PSum[i];
		}

		BigInteger result = BigInteger.ZERO;
		long resultLong = 0;
		int startP = p - 1;
		int startR = r - 1;
		for (int i = q - 1; i >= 0; i--) {
			while (startP >= 0 && Q.get(i) < P.get(startP)) {
				startP--;
			}
			if (startP < 0) {
				continue;
			}
			while (startR >= 0 && Q.get(i) < R.get(startR)) {
				startR--;
			}
			if (startR < 0) {
				continue;
			}
			/*BigInteger temp1 = new BigInteger(Long.toString(Q.get(i) * (startP + 1)))
					.add(new BigInteger(Long.toString(PSum[startP])));
			BigInteger temp2 = new BigInteger(Long.toString(Q.get(i) * (startR + 1)))
					.add(new BigInteger(Long.toString(RSum[startR])));*/
			long temp1 = Q.get(i) * (startP + 1) + PSum[startP];
			long temp2 = Q.get(i) * (startR + 1) + RSum[startR];
			/*BigInteger TEMP1 = new BigInteger(Long.toString(temp1));
			BigInteger TEMP2 = new BigInteger(Long.toString(temp2));
			result = result.add(TEMP1.multiply(TEMP2)).mod(MOD);*/
			resultLong = (resultLong + ((temp1%MODLONG)*(temp2%MODLONG)))%MODLONG;
		}
		return resultLong;
	}

}
