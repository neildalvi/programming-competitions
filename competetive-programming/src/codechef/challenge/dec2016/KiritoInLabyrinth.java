package codechef.challenge.dec2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class KiritoInLabyrinth {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		KiritoInLabyrinth obj = new KiritoInLabyrinth();
		while (--t >= 0) {
			int n = Integer.parseInt(br.readLine());
			int[] input = new int[n];
			int index = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int max = 1;
			while (st.hasMoreTokens()) {
				input[index++] = Integer.parseInt(st.nextToken());
				// max = obj.solve(Integer.parseInt(st.nextToken()), max);
			}
			sb.append(obj.solve(input)).append("\n");
			// sb.append(max).append("\n");
		}
		System.out.print(sb);
	}

	int[] cnt;
	int[] maxHeap;
	int maxHeapSize;

	public int solve(int[] input) {
		int max = 0;
		cnt = new int[input.length];
		maxHeap = new int[input.length];
		maxHeapSize = 0;
		for (int j = 0; j < input.length; j++) {
			int tempMax = 0;
			for (int i = 0; i < maxHeapSize; i++) {
				if (isGcdMoreThanOne(input[maxHeap[i]], input[j])) {
					tempMax = cnt[maxHeap[i]];
					break;
				}
			}
			tempMax++;
			cnt[j] = tempMax;

			maxHeap[maxHeapSize] = j;
			int current = maxHeapSize;
			while (cnt[maxHeap[current]] > cnt[maxHeap[current / 2]]) {
				int tmp = maxHeap[current];
				maxHeap[current] = maxHeap[current / 2];
				maxHeap[current / 2] = tmp;
				current = current / 2;
			}
			if(input.length/2+1 >= maxHeapSize ) {
				maxHeapSize++;
			}

			max = Math.max(tempMax, max);
		}
		return max;
	}

	class ElemCnt {
		private int elem;
		private int cnt;
		private boolean prime;

		public int getElem() {
			return elem;
		}

		public int getCnt() {
			return cnt;
		}

		public boolean isPrime() {
			return prime;
		}

		public ElemCnt(int elem, int cnt, boolean prime) {
			super();
			this.elem = elem;
			this.cnt = cnt;
			this.prime = prime;
		}

		public String toString() {
			return "(" + elem + "-" + cnt + "-" + (prime ? "P" : "NP") + ")";
		}

	}

	public boolean isGcdMoreThanOne(int a, int b) {
		if (a == 1 || b == 1)
			return false;
		if (a == 0) {
			if (b > 1)
				return true;
			else
				return false;
		}
		if (a > b) {
			return isGcdMoreThanOne(a % b, b);
		} else {
			return isGcdMoreThanOne(b % a, a);
		}
	}

	public int[] getPrimesBySieve(int n) {

		boolean[] flag = new boolean[n + 1];
		int count = 0;
		for (int i = 2; i < flag.length; i++) {
			if (!flag[i]) {
				count++;
				for (int j = i + i; j < flag.length; j += i) {
					flag[j] = true;
				}
			}
		}
		int[] primes = new int[count];
		int index = 0;
		for (int i = 2; i < flag.length; i++) {
			if (!flag[i]) {
				primes[index++] = i;
			}
		}
		return primes;
	}

	public Set<Integer> getPrimeSetBySieve(int n) {

		boolean[] flag = new boolean[n + 1];
		int count = 0;
		for (int i = 2; i < flag.length; i++) {
			if (!flag[i]) {
				count++;
				for (int j = i + i; j < flag.length; j += i) {
					flag[j] = true;
				}
			}
		}
		Set<Integer> set = new HashSet<Integer>();
		int index = 0;
		for (int i = 2; i < flag.length; i++) {
			if (!flag[i]) {
				set.add(i);
				// primes[index++] = i;

			}
		}
		return set;
	}
}
