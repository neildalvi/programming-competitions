package core.sort.array;

public class BinSrchExp {

	public static void main(String[] args) {
		int[] n = new int[] { 1, 2, 2, 3, 3, 3, 5, 6, 7, 7, 7, 8, 9 };
		int left = 0, right = n.length;
		int key = 3, index = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (key < n[mid]) {
				right = mid - 1;
			} else if (key > n[mid]) {
				left = mid + 1;
			} else if (key == n[mid]) {
				index = mid;
				right = mid - 1;
			}
		}
		System.out.println(index);
	}
}
