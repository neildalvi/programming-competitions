package codechef.challenge.jan2017;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CapitalMovement {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		int t = readInt(bis);
		while (--t >= 0) {
			CapitalMovement obj = new CapitalMovement();
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

		StringBuilder sb = new StringBuilder();

		Arrays.sort(portal, new Comparator<Integer[]>() {
			public int compare(Integer[] s1, Integer[] s2) {
				if (s1[0] == s2[0]) {
					return s1[1].compareTo(s2[1]);
				}
				return s1[0].compareTo(s2[0]);
			}
		});

		Arrays.sort(planets, new Comparator<Integer[]>() {
			public int compare(Integer[] p1, Integer[] p2) {
				return -p1[0] + p2[0];
			}
		});

		int k = 0;
		Set<Integer> invalidPlanets = new HashSet<Integer>(planets.length);
		for (int i = 1; i <= planets.length; i++) {
			invalidPlanets.clear();
			invalidPlanets.add(i);
			while (k < portal.length && portal[k][0] == i) {
				invalidPlanets.add(portal[k][1]);
				k++;
			}
			if (invalidPlanets.size() == planets.length) {
				sb.append(0);
			} else {
				int left = 0;
				int right = planets.length;
				int mid, max = 0;

				/*
				 * if (invalidPlanets.remove(planets[mid][1])) { if
				 * (invalidPlanets.size() == mid - 1) { if (mid + 1 <=
				 * planets.length) { max = planets[mid + 1][1]; break; } } else
				 * if (invalidPlanets.size() < mid - 1) { right = mid - 1; }
				 * else { left = mid + 1; }
				 * 
				 * } else { max = planets[mid][1]; if (invalidPlanets.size() ==
				 * mid - 1) { break; } else if (invalidPlanets.size() < mid - 1)
				 * { right = mid - 1; } else { left = mid + 1; } }
				 */
				// }
				/*
				 * while (invalidPlanets.remove(planets[l][1])) { l++; }
				 */
				sb.append(binaryReturn(planets, invalidPlanets, 0,
						planets.length));
			}
			if (i != planets.length) {
				sb.append(" ");
			}
		}

		return sb.toString();

	}

	private static int binaryReturn(Integer[][] planets,
			Set<Integer> invalidPlanets, int left, int right) {
		if (right < left)
			return 0;
		int max = 0, mid = (left + right) / 2;
		if (!invalidPlanets.remove(planets[mid][1])) {
			max = planets[mid][1];
		}
		if (invalidPlanets.size() < mid) {
			int result = binaryReturn(planets, invalidPlanets, left, mid - 1);
			if (result != 0)
				max = result;
		} else {
			int result = binaryReturn(planets, invalidPlanets, left, mid - 1);
			if (result != 0)
				max = result;
			result = binaryReturn(planets, invalidPlanets, mid + 1, right);
			if (result != 0 && max == 0)
				max = result;
		}
		return max;
	}

}
