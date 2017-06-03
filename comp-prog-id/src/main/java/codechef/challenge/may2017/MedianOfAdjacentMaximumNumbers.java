package codechef.challenge.may2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MedianOfAdjacentMaximumNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(-11%5);
		System.out.println(1%5);
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			int n = Integer.parseInt(br.readLine());
			String[] aStr = br.readLine().split(" ");
			List<Integer> a = new ArrayList<Integer>(aStr.length);
			for (int i = 0; i < aStr.length; i++) {
				a.add(Integer.parseInt(aStr[i]));
			}
			Tuple<Integer, String> result = calc(n, a);
			System.out.println(result.x);
			System.out.println(result.y);
		}*/
	}

	public static Tuple<Integer, String> calc(int n, List<Integer> prerequisite) {
		Collections.sort(prerequisite);
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = n; i < n; i++, j++) {
			sb.append(prerequisite.get(i)).append(" ").append(prerequisite.get(j)).append(" ");
		}
		return new MedianOfAdjacentMaximumNumbers().new Tuple<Integer, String>(prerequisite.get(n+n/2), sb.toString());

	}

	class Tuple<X, Y> {
		public final X x;
		public final Y y;

		public Tuple(X x, Y y) {
			this.x = x;
			this.y = y;
		}
	}

}
