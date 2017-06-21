package core.math;

import java.math.BigInteger;

public class GCDCalculator {

	/**
	 * Note. a should be lesser then b
	 * @param a
	 * @param b
	 * @return
	 */
	public BigInteger calcGCD(BigInteger a, BigInteger b) {
		if (a.equals(BigInteger.ZERO)) {
			return b;
		}
		return calcGCD(b.mod(a), a);
	}
}
