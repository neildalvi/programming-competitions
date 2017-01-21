package codechef.challenge.jan2017;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CapitalMovement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		int t = readInt(bis);
		while (--t >= 0) {
			CapitalMovement obj = new CapitalMovement();
			int n = readInt(bis);
			Planet[] planets = new Planet[n];
			for (int i = 0; i < n; i++) {
				int population = readInt(bis);
				Planet planet = new CapitalMovement().new Planet(population, i + 1);
				planets[i] = planet;
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

	public static String solve(Integer[][] portal, Planet[] planets) {
		
		Arrays.sort(portal, new Comparator<Integer[]>() {
			public int compare(Integer[] s1, Integer[] s2) {
				if (s1[0] == s2[0]) {
					return s1[1].compareTo(s2[1]);
				}
				return s1[0].compareTo(s2[0]);
			}
		});

		StringBuilder sb = new StringBuilder();

		Heap heap = new CapitalMovement().new Heap();
		heap.buildHeap(planets);
		int k = 0;
		List<Integer> invalidPlanets = new ArrayList<Integer>();
		for (int i = 1; i <= planets.length; i++) {
			invalidPlanets.clear();
			invalidPlanets.add(i);
			while (k < portal.length && portal[k][0] == i) {
				invalidPlanets.add(portal[k][1]);
				k++;
			}
			int lenIndex = planets.length;
			if (invalidPlanets.size() == planets.length) {
				sb.append(0);
			} else {
				int n = planets.length;
				for (int j = n - 1; j >= 0; j--) {
					if (invalidPlanets.remove((Integer) planets[j].index)) {
						heap.exch(planets, j + 1, lenIndex);
						heap.sink(planets, j + 1, --lenIndex);
					}
				}
				sb.append(planets[0].index);
			}
			if (i != planets.length) {
				sb.append(" ");
				for (int j = lenIndex; j < planets.length; j++) {
					heap.insert(planets, j);
				}
			}
		}

		return sb.toString();

	}

	class Heap {

		public void buildHeap(Comparable[] pq) {
			int n = pq.length;
			for (int k = n / 2; k >= 1; k--)
				sink(pq, k, n);
		}

		public void removeRoot(Comparable[] pq, int n) {
			sink(pq, 1, n);
		}

		private void sink(Comparable[] pq, int k, int n) {
			while (2 * k <= n) {
				int j = 2 * k;
				if (j < n && less(pq, j, j + 1))
					j++;
				if (!less(pq, k, j))
					break;
				exch(pq, k, j);
				k = j;
			}
		}

		public void insert(Comparable[] pq, int n) {
			// pq[n - 1] = elem;
			int down = n;
			int top = down / 2;
			while (top != 0) {
				if (!less(pq, top, down))
					break;
				exch(pq, top, down);
				down = top;
				top = down / 2;
			}
		}

		private boolean less(Comparable[] pq, int i, int j) {
			return pq[i - 1].compareTo(pq[j - 1]) < 0;
		}

		private void exch(Object[] pq, int i, int j) {
			Object swap = pq[i - 1];
			pq[i - 1] = pq[j - 1];
			pq[j - 1] = swap;
		}

		private boolean less(Comparable v, Comparable w) {
			return v.compareTo(w) < 0;
		}
	}

	class Planet implements Comparable {

		private int population;
		private int index;

		public Planet(int population, int index) {
			this.population = population;
			this.index = index;
		}

		public int compareTo(Object arg0) {
			Planet other = (Planet) arg0;
			return this.population - other.population;
		}

		@Override
		public String toString() {
			return population + " - " + index;
		}
	}
	

}