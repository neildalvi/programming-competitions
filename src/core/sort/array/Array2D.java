package core.sort.array;

import java.util.Arrays;
import java.util.Comparator;

public class Array2D {

	Integer[][] array2d = new Integer[][] { { 2, 4 }, { 4, 5 }, { 8, 6, } };

	public void sort2dArray(Integer[][] array2d) {
		if (array2d == null || array2d.length == 0) {
			return;
		}
		if (array2d[0].length < 2) {
			throw new IllegalArgumentException("Expecting a 2d array");
		}
		Arrays.sort(array2d, new Comparator<Integer[]>() {
			public int compare(Integer[] s1, Integer[] s2) {
				if(s1[0] == s2[0]) {
					return s1[1].compareTo(s2[1]);
				}
				return s1[0].compareTo(s2[0]);
			}
		});
	}
}
