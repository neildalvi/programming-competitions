package codechef.challenge.jan2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

class CapitalMovementLinear {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<Integer, Integer> heap = new TreeMap<Integer, Integer>();

		int t = Integer.parseInt(br.readLine());
		String[] words;
		int[] planet;
		StringBuilder sb = new StringBuilder();
		while (--t >= 0) {
			heap.clear();
			int n = Integer.parseInt(br.readLine());
			planet = new int[n + 1];

			words = br.readLine().split(" ");
			List<Integer>[] portal = new List[n + 1];
			for (int i = 1; i <= n; i++) {
				planet[i] = Integer.parseInt(words[i - 1]);
				portal[i] = new ArrayList<Integer>();
				portal[i].add(i);
				heap.put(planet[i], i);
			}
			for (int i = 0; i < n - 1; i++) {
				words = br.readLine().split(" ");
				int u = Integer.parseInt(words[0]);
				int v = Integer.parseInt(words[1]);
				portal[u].add(v);
				portal[v].add(u);
			}
			solve(sb, portal, planet, heap);
		}
		System.out.println(sb.toString());
	}

	public static StringBuilder solve(StringBuilder sb, List<Integer>[] portal, int[] planets,
			TreeMap<Integer, Integer> heap) {

		TreeMap<Integer, Integer> backup = new TreeMap<Integer, Integer>();
		int i1 = 0;
		i1 = heap.lastEntry().getValue();

		int m2 = Integer.MIN_VALUE;
		int i2 = 0;
		int m3 = Integer.MIN_VALUE;
		int i3 = 0;
		for (Integer key : portal[i1]) {
			backup.put(planets[key], heap.remove(planets[key]));
			if (planets[key] > m3 && key != i1) {
				i3 = key;
				m3 = planets[key];
			}
		}
		if (!heap.isEmpty()) {
			m2 = heap.lastEntry().getKey();
			i2 = heap.lastEntry().getValue();
		}
		heap.putAll(backup);
		backup.clear();

		int i4 = 0;

		for (Integer key : portal[i3]) {
			backup.put(planets[key], heap.remove(planets[key]));
		}
		if (!heap.isEmpty()) {
			i4 = heap.lastEntry().getValue();
		}
		heap.putAll(backup);
		backup.clear();
		
		Set<Integer> nebOfMax = new HashSet<Integer>(portal[i1]);
		Set<Integer> nebOfMaxOfNebOfMax = new HashSet<Integer>(portal[i2]);

		for (int i = 1; i < planets.length; i++) {
			if (i == i1) {
				sb.append(i2);
			} else if (i == i3) {
				sb.append(i4);
			} else if (nebOfMax.contains(i)) {
				if (m2 > m3) {
					if (nebOfMaxOfNebOfMax.contains(i)) {
						int i5 = 0;
						for (Integer key:portal[i]) {
							backup.put(planets[key], heap.remove(planets[key]));
						}
						if (!heap.isEmpty()) {
							i5 = heap.lastEntry().getValue();
						}
						heap.putAll(backup);
						backup.clear();
						sb.append(i5);
					} else {
						sb.append(i2);
					}
				} else {
					sb.append(i3);
				}
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