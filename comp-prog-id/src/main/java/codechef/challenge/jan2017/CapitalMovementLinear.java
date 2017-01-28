package codechef.challenge.jan2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class CapitalMovementLinear {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		String[] words;
		int[] planet;
		StringBuilder sb = new StringBuilder();
		while (--t >= 0) {
			int n = Integer.parseInt(br.readLine());
			planet = new int[n + 1];
			List<Integer>[] portal = new List[n + 1];

			words = br.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				planet[i] = Integer.parseInt(words[i - 1]);
				portal[i] = new ArrayList<Integer>();
				portal[i].add(i);
			}
			for (int i = 0; i < n - 1; i++) {
				words = br.readLine().split(" ");
				int u = Integer.parseInt(words[0]);
				int v = Integer.parseInt(words[1]);
				portal[u].add(v);
				portal[v].add(u);
			}
			solve(sb, portal, planet);
		}
		System.out.println(sb.toString());
		br.close();
	}

	public static StringBuilder solve(StringBuilder sb, List<Integer>[] portal, int[] planets) {

		TreeMap<Integer, Integer> heap = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> backup = new TreeMap<Integer, Integer>();
		int i1 = 0;

		for (int i = 1; i < planets.length; i++) {
			heap.put(planets[i], i);
		}
		i1 = heap.lastEntry().getValue();

		for (int i = 1; i < planets.length; i++) {
			if (i == i1 || portal[i1].contains(i)) {
				int i5 = 0;
				for (Integer key : portal[i]) {
					backup.put(planets[key], heap.remove(planets[key]));
				}
				if (!heap.isEmpty()) {
					i5 = heap.lastEntry().getValue();
				}
				heap.putAll(backup);
				backup.clear();
				sb.append(i5);
			} else {
				sb.append(i1);
			}
			if (i != planets.length - 1) {
				sb.append(" ");
			}
		}
		sb.append("\n");
		return sb;
	}

}