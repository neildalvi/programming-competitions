package codechef.challenge.june2017;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class TripletsTest {

	@Test
	public void testNormal() {
		List<Long> P = new ArrayList<Long>();
		P.add(1l);
		P.add(2l);
		P.add(3l);
		List<Long> Q = new ArrayList<Long>();
		Q.add(5l);
		List<Long> R = new ArrayList<Long>();
		R.add(4l);
		R.add(5l);
		R.add(6l);
		long result = Triplets.calc(P.size(), Q.size(), R.size(), P, Q, R);
		Assert.assertEquals(399, result);
	}
	
	@Test
	public void testMultiQ() {
		List<Long> P = new ArrayList<Long>();
		P.add(1l);
		P.add(2l);
		P.add(3l);
		List<Long> Q = new ArrayList<Long>();
		Q.add(5l);
		Q.add(4l);
		List<Long> R = new ArrayList<Long>();
		R.add(4l);
		R.add(5l);
		R.add(6l);
		long result = Triplets.calc(P.size(), Q.size(), R.size(), P, Q, R);
		Assert.assertEquals(399+18*8, result);
	}
	
	@Test
	public void testNoMatchP() {
		List<Long> P = new ArrayList<Long>();
		P.add(11l);
		P.add(12l);
		P.add(13l);
		List<Long> Q = new ArrayList<Long>();
		Q.add(5l);
		List<Long> R = new ArrayList<Long>();
		R.add(4l);
		R.add(5l);
		R.add(6l);
		long result = Triplets.calc(P.size(), Q.size(), R.size(), P, Q, R);
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void testNoMatchR() {
		List<Long> P = new ArrayList<Long>();
		P.add(1l);
		P.add(2l);
		P.add(3l);
		List<Long> Q = new ArrayList<Long>();
		Q.add(5l);
		List<Long> R = new ArrayList<Long>();
		R.add(14l);
		R.add(15l);
		R.add(16l);
		long result = Triplets.calc(P.size(), Q.size(), R.size(), P, Q, R);
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void testEmpty() {
		List<Long> P = new ArrayList<Long>();
		List<Long> Q = new ArrayList<Long>();
		List<Long> R = new ArrayList<Long>();
		long result = Triplets.calc(P.size(), Q.size(), R.size(), P, Q, R);
		Assert.assertEquals(0, result);
	}

}
