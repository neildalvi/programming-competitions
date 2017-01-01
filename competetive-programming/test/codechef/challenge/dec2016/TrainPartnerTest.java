package codechef.challenge.dec2016;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrainPartnerTest {

	@Test
	public void testStdCases() {
		
		assertEquals("6UB", new TrainPartner().findPartner(3));
		assertEquals("4LB", new TrainPartner().findPartner(1));
		assertEquals("5MB", new TrainPartner().findPartner(2));
		assertEquals("1LB", new TrainPartner().findPartner(4));
		assertEquals("2MB", new TrainPartner().findPartner(5));
		assertEquals("3UB", new TrainPartner().findPartner(6));
		assertEquals("8SU", new TrainPartner().findPartner(7));
		assertEquals("7SL", new TrainPartner().findPartner(8));
		
	}
	
	@Test
	public void testPlus8Cases() {
		
		assertEquals("14UB", new TrainPartner().findPartner(8+3));
		assertEquals("12LB", new TrainPartner().findPartner(8+1));
		assertEquals("13MB", new TrainPartner().findPartner(8+2));
		assertEquals("9LB", new TrainPartner().findPartner(8+4));
		assertEquals("10MB", new TrainPartner().findPartner(8+5));
		assertEquals("11UB", new TrainPartner().findPartner(8+6));
		assertEquals("16SU", new TrainPartner().findPartner(8+7));
		assertEquals("15SL", new TrainPartner().findPartner(8+8));
		
	}

}
