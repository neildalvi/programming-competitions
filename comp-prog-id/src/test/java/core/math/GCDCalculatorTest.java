package core.math;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class GCDCalculatorTest {

	@Test
	public void test() {
		assertEquals(1, new GCDCalculator().calcGCD(new BigInteger("83"), new BigInteger("111")).intValue());
		assertEquals(6, new GCDCalculator().calcGCD(new BigInteger("30"), new BigInteger("42")).intValue());
	}

}
