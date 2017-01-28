package codechef.challenge.jan2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CapitalMovementSolnM {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int T = 0;
		String ans = "";
		while (T-- != 0) {

			Integer[][] portal = new Integer[1][2];
			int[] planet = new int[1];

			ans = solve(portal, planet);
		}
		System.out.println(ans);
	}

	static String solve(Integer[][] portal, int[] planet) {
		StringBuilder ans = new StringBuilder();
		int N = planet.length;

		long ar[] = new long[N];

		ArrayList<ArrayList<Integer>> as = new ArrayList<>();

		TreeMap<Long, Integer> tmap = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			ar[i] = planet[i];
			tmap.put(ar[i], i);
			as.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N - 1; i++) {

			int u = portal[i][0] - 1;
			int v = portal[i][1] - 1;

			as.get(u).add(v);
			as.get(v).add(u);

		}
		for (int i = 0; i < N; i++) {
			TreeMap<Long, Integer> temp = new TreeMap<>();
			temp.put(ar[i], tmap.get(ar[i]));
			tmap.remove(ar[i]);

			for (Integer t : as.get(i)) {
				tmap.remove(ar[t]);
				temp.put(ar[t], t);
			}

			if (tmap.isEmpty()) {
				// System.out.print(0 + " ");
				ans.append(0 + " ");
			} else {
				// System.out.print((tmap.get(tmap.lastKey())+1) + " ");
				ans.append((tmap.get(tmap.lastKey()) + 1) + " ");
			}
			tmap.putAll(temp);
		}
		// System.out.println();
		//ans.append("\n");
		
		return ans.substring(0, ans.length()-1);
	}

}