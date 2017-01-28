package codechef.challenge.jan2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;

class CapiMove {

	public static void main(String[] args) throws IOException {
		// Reader r = new FileReader(Paths.get("input",
		// "CapiMove.txt").toFile());
		Reader r = new InputStreamReader(System.in);

		BufferedReader input = new BufferedReader(r);

		StringBuilder output = new StringBuilder();

		int t = Integer.parseInt(input.readLine());
		while (t-- > 0) {

			int n = Integer.parseInt(input.readLine());
			StringTokenizer line = new StringTokenizer(input.readLine());

			int[] p = new int[n];
			TreeMap<Integer, Integer> p_i = new TreeMap<>();
			ArrayList<ArrayList<Integer>> neighbors = new ArrayList<>(n);

			for (int i = 0; i < n; i++) { // n planets
				p[i] = Integer.parseInt(line.nextToken());
				p_i.put(p[i], i); // distinct population
				neighbors.add(new ArrayList<Integer>());
			}
			int capital = p_i.lastEntry().getValue();

			for (int i = 1; i < n; i++) { // n - 1 edges
				line = new StringTokenizer(input.readLine());

				int v = Integer.parseInt(line.nextToken()) - 1;
				int u = Integer.parseInt(line.nextToken()) - 1;

				neighbors.get(v).add(u);
				neighbors.get(u).add(v);
			}

			HashSet<Integer> capital_neighbors = new HashSet<>(
					neighbors.get(capital));

			// Simulate infection of planet Pi
			for (int i = 0; i < n; i++) {
				if (i == capital || capital_neighbors.contains(i)) {

					TreeMap<Integer, Integer> backup = new TreeMap<>();

					backup.put(p[i], i);
					p_i.remove(p[i]);

					for (Integer neighbor : neighbors.get(i)) {
						backup.put(p[neighbor], neighbor);
						p_i.remove(p[neighbor]);
					}

					if (p_i.isEmpty()) {
						output.append(0);
					} else {
						output.append(p_i.lastEntry().getValue() + 1);
					}

					p_i.putAll(backup); // restore

				} else {
					output.append(capital + 1);
				}
				output.append(' ');
			}

			output.append('\n');
		}
		System.out.println(output.toString());

		input.close();
	}
}