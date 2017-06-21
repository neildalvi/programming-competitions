package core.primitive;

public class BitOperations {

	public static short countBits(int x) {
		short numBits = 0;
		while (x != 0) {
			numBits += (x & 1);
			// clang-format off
			x >>>= 1;
			// clang-format on
		}
		return numBits;
	}

	/**
	 * <pre>
	 * i-th and j-th bits differ. We will swap them by flipping their values.
	   Select the bits to flip with bitMask. Since x^1 = 0 when x = 1 and 1
	   when x = 0, we can perform the flip XOR.
	 * </pre>
	 * 
	 * @param x
	 * @param i
	 * @param j
	 * @return
	 */
	public static long swapBits(long x, int i, int j) {
		if (((x >>> i) & 1) != ((x >>> j) & 1)) {
			long bitMask = (1L << i) | (1L << j);
			x ^= bitMask;
		}
		return x;
	}
}
