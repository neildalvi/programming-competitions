package codechef.challenge.may2017;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChefAndSubArrayTest {

	private static final String[] _11001 = new String[] { "1", "1", "0", "0", "1" };
	private static final char[] PRINT_ONLY = new char[] { '?', '?' };
	private static final char[] ROTATE_ONLY = new char[] { '!', '!', '!' };
	private static final char[] SINGLE_THEN_DOUBLE_ROTATE = new char[] { '?', '!', '?', '!', '!', '?' };

	@Test
	public void testSample() {
		String result = new ChefAndSubArray().calc(5, 3, 4, _11001, new char[] { '?', '!', '!', '?' });
		assertEquals("2\n3\n", result);
	}

	@Test
	public void testSample2() {
		String result = new ChefAndSubArray().calc(5, 3, 4, _11001,
				new char[] { '?', '!', '!', '!', '!', '?', '!', '!', '?', '!', '!', '!', '!', '!', '!', '?' });
		assertEquals("2\n2\n3\n3\n", result);
		result = new ChefAndSubArray().calc(5, 1, 4, _11001,
				new char[] { '?', '!', '!', '!', '!', '?', '!', '!', '?', '!', '!', '!', '!', '!', '!', '?' });
		assertEquals("1\n1\n1\n1\n", result);
	}

	@Test
	public void testSingleElement() {
		String result = new ChefAndSubArray().calc(1, 1, 0, new String[] { "1" }, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("1\n1\n1\n", result);
		result = new ChefAndSubArray().calc(1, 1, 0, new String[] { "0" }, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("0\n0\n0\n", result);
		result = new ChefAndSubArray().calc(1, 1, 0, new String[] { "0" }, ROTATE_ONLY);
		assertEquals("", result);
		result = new ChefAndSubArray().calc(1, 1, 0, new String[] { "1" }, ROTATE_ONLY);
		assertEquals("", result);
	}
	
	@Test
	public void testFrameBiggerThanInput() {
		String result = new ChefAndSubArray().calc(1, 2, 0, new String[] { "1" }, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("1\n1\n1\n", result);
	}
	
	@Test 
	public void testDoubleElement() {
		String result = new ChefAndSubArray().calc(2, 1, 0, new String[] { "1" ,"0" }, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("1\n1\n1\n", result);
		result = new ChefAndSubArray().calc(2, 1, 0, new String[] { "0" ,"1" }, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("1\n1\n1\n", result);
		result = new ChefAndSubArray().calc(2, 1, 0, new String[] { "1" ,"1" }, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("1\n1\n1\n", result);
		result = new ChefAndSubArray().calc(2, 1, 0, new String[] { "0" ,"0" }, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("0\n0\n0\n", result);
		result = new ChefAndSubArray().calc(2, 2, 0, new String[] { "1" ,"0" }, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("1\n1\n1\n", result);
		result = new ChefAndSubArray().calc(2, 2, 0, new String[] { "0" ,"1" }, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("1\n1\n1\n", result);
		result = new ChefAndSubArray().calc(2, 2, 0, new String[] { "1" ,"1" }, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("2\n2\n2\n", result);
		result = new ChefAndSubArray().calc(2, 2, 0, new String[] { "0" ,"0" }, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("0\n0\n0\n", result);
		
	}

	@Test
	public void testSampleLowerBound01x() {
		String result = new ChefAndSubArray().calc(5, 5, 4, _11001, SINGLE_THEN_DOUBLE_ROTATE);
		assertEquals("3\n3\n3\n", result);
	}

}
