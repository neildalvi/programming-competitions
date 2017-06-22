package core.array;

import java.util.List;

public class ArrayWithDuplicates {

	public static int deleteDuplicates(List<Integer> A) {
		if (A.isEmpty()) {
			return 0;
		}

		int writeIndex = 1;
		for (int i = 1; i < A.size(); ++i) {
			if (!A.get(writeIndex - 1).equals(A.get(i))) {
				A.set(writeIndex++, A.get(i));
			}
		}
		return writeIndex;
	}
}
