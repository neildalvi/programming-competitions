package core.primitive;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void testIsPalindromeNumber() {
		assertEquals(true, Palindrome.isPalindromeNumber(12321));
		assertEquals(false, Palindrome.isPalindromeNumber(12322));
		assertEquals(true, Palindrome.isPalindromeNumber(123321));
		
	}

}
