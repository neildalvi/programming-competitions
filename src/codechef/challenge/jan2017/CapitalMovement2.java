package codechef.challenge.jan2017;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CapitalMovement2 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		int t = readInt(bis);
		while (--t >= 0) {
			CapitalMovement2 obj = new CapitalMovement2();
			int n = readInt(bis);
			Integer[][] planets = new Integer[n][2];
			for (int i = 0; i < n; i++) {
				int population = readInt(bis);
				planets[i][0] = population;
				planets[i][1] = i + 1;
			}
			Integer[][] portal = new Integer[2 * n - 2][2];
			int k = 0;
			for (int i = 0; i < n - 1; i++) {
				Integer u = readInt(bis);
				Integer v = readInt(bis);
				portal[k][0] = u;
				portal[k][1] = v;
				k++;
				portal[k][0] = v;
				portal[k][1] = u;
				k++;
			}

			System.out.println(solve(portal, planets));

		}

		if (bis != null) {
			bis.close();
		}
	}

	public static int readInt(BufferedInputStream bis) throws IOException {
		int input = bis.read();
		while (!checkIfNumber(input)) {
			input = bis.read();
		}
		int number = input - 48;
		input = bis.read();
		while (checkIfNumber(input)) {
			number = 10 * number + input - 48;
			input = bis.read();
		}
		return number;
	}

	private static boolean checkIfNumber(int input) {
		if (input >= 48 && input <= 57) {
			return true;
		}
		return false;
	}

	public static String solve(Integer[][] portal, Integer[][] planets) {

		if (planets.length == 1) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();

		int[] ans = new int[planets.length];

		sortPortal(portal);

		Integer[] max = findMax(planets);
		Arrays.fill(ans, max[1]);

		int startIndex = findStartingPoint(portal, max);
		Set<Integer> neighboursOfMax = extractNeB(portal, max, startIndex);
		Integer[] maxAmongNeighbours = findMax(planets, neighboursOfMax);

		Integer[] maxAmongRemain = findMax(planets, max, neighboursOfMax);
		startIndex = findStartingPoint(portal, maxAmongRemain);
		Set<Integer> neighboursOfMaxRem = extractNeB(portal, maxAmongRemain, startIndex);

		// assing max to other neigh
		Iterator<Integer> iterator = neighboursOfMax.iterator();
		while (iterator.hasNext()) {
			int index = iterator.next();
			if (index != maxAmongNeighbours[1]) {
				if (!neighboursOfMaxRem.contains(index)//Test
						&& maxAmongRemain[0] > maxAmongNeighbours[0]) {
					ans[index - 1] = maxAmongRemain[1];
				} else {
					ans[index - 1] = maxAmongNeighbours[1];
				}
			}
		}

		// find max among remaining to the max.
		ans[max[1] - 1] = maxAmongRemain[1];

		startIndex = findStartingPoint(portal, maxAmongNeighbours);
		Set<Integer> neighboursOfMaxNeb = new HashSet<Integer>();
		for (int i = startIndex; i < portal.length; i++) {
			if (portal[i][0] != maxAmongNeighbours[1])
				break;
			neighboursOfMaxNeb.add(portal[i][1]);
		}

		maxAmongRemain = new Integer[] { 0, 0 };
		for (int i = 0; i < planets.length; i++) {
			if (!neighboursOfMaxNeb.contains(planets[i][1])
					&& planets[i][1] != maxAmongNeighbours[1]  && planets[i][0] > maxAmongRemain[0]) {
				maxAmongRemain[0] = planets[i][0];
				maxAmongRemain[1] = planets[i][1];
			}
		}

		ans[maxAmongNeighbours[1] - 1] = maxAmongRemain[1];

		for (int i = 0; i < ans.length; i++) {
			sb.append(ans[i]);
			if (i != ans.length - 1) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	private static Integer[] findMax(Integer[][] planets, Integer[] max,
			Set<Integer> neighboursOfMax) {
		Integer[] maxRem = new Integer[] { 0, 0 };
		for (int i = 0; i < planets.length; i++) {
			if (!neighboursOfMax.contains(planets[i][1])
					&& planets[i][1] != max[1] && planets[i][0] > maxRem[0]) {
				maxRem[0] = planets[i][0];
				maxRem[1] = planets[i][1];
			}
		}
		return maxRem;
	}

	private static Integer[] findMax(Integer[][] planets,
			Set<Integer> neighboursOfMax) {
		Iterator<Integer> iterator = neighboursOfMax.iterator();
		Integer[] maxNeb = new Integer[] { 0, 0 };
		while (iterator.hasNext()) {
			Integer neb = iterator.next();
			if (maxNeb[0] < planets[neb - 1][0]) {
				maxNeb[0] = planets[neb - 1][0];
				maxNeb[1] = planets[neb - 1][1];
			}
		}
		return maxNeb;
	}

	private static Set<Integer> extractNeB(Integer[][] portal, Integer[] max,
			int startIndex) {
		Set<Integer> neighboursOfMax = new HashSet<Integer>();
		for (int i = startIndex; i < portal.length; i++) {
			if (portal[i][0] != max[1])
				break;
			neighboursOfMax.add(portal[i][1]);

		}
		return neighboursOfMax;
	}

	private static Integer[] findMax(Integer[][] planets) {
		Integer[] max = new Integer[] { 0, 0 };
		for (int i = 0; i < planets.length; i++) {
			if (max[0] < planets[i][0]) {
				max[0] = planets[i][0];
				max[1] = planets[i][1];
			}
		}
		return max;
	}

	private static void sortPortal(Integer[][] portal) {
		Arrays.sort(portal, new Comparator<Integer[]>() {
			public int compare(Integer[] s1, Integer[] s2) {
				if (s1[0] == s2[0]) {
					return s1[1].compareTo(s2[1]);
				}
				return s1[0].compareTo(s2[0]);
			}
		});
	}

	public static int findStartingPoint(Integer[][] portal, Integer[] max) {
		int left = 0, right = portal.length, key = max[1], startIndex = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (key < portal[mid][0]) {
				right = mid - 1;
			} else if (key > portal[mid][0]) {
				left = mid + 1;
			} else if (key == portal[mid][0]) {
				startIndex = mid;
				right = mid - 1;
			}
		}
		return startIndex;
	}
}
