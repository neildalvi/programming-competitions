package codechef.challenge.jan2017;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class CapitalMovement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		int t = readInt(bis);
		while (--t >= 0) {
			CapitalMovement obj = new CapitalMovement();
			int n = readInt(bis);
			int[] planets = new int[n];
			for (int i = 0; i < n; i++) {
				planets[i] = readInt(bis);
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

	public static String solve(Integer[][] portal, int[] planets) {

		/*Arrays.sort(portal, new Comparator<Integer[]>() {
			public int compare(Integer[] s1, Integer[] s2) {
				if (s1[0] == s2[0]) {
					return s1[1].compareTo(s2[1]);
				}
				return s1[0].compareTo(s2[0]);
			}
		});*/

		StringBuilder sb = new StringBuilder();
		int N = planets.length;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		});
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int j = 0; j < N; j++) {
			heap.offer(planets[j]);
			map.put(planets[j], j+1);
		}
		int k1 = 0, k0 = 0;
		Set<Integer> backup = new HashSet<Integer>();
		for (int i = 1; i <= N; i++) {

			backup.clear();
			heap.remove(planets[i - 1]);
			while (k1 < portal.length && portal[k1][0] == i) {
				heap.remove(planets[portal[k1][1] - 1]);
				k1++;
			}
			int lenIndex = N;
			if (heap.isEmpty()) {
				sb.append(0);
			} else {
				int n = N;
				sb.append(map.get(heap.peek()));
			}
			if (i != N) {
				sb.append(" ");
				heap.offer(planets[i - 1]);
				for (int j = k0; j < k1; j++) {
					heap.offer(planets[portal[j][1] - 1]);
				}
			}
		}

		return sb.toString();

	}

}