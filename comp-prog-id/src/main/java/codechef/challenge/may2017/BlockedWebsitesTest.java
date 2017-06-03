package codechef.challenge.may2017;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import codechef.challenge.may2017.BlockedWebsites.Tuple;

public class BlockedWebsitesTest {

	@Test
	public void testSample() {
		String[] words = new String[]{"- codeforces","+ codechef","- youtube","+ google"};
		Tuple<Boolean, List<String>> result = new BlockedWebsites().findPrefix(words);
		List<String> expectedResult = new ArrayList<String>(){{add("codef");add("y");}};
		Tuple<Boolean, List<String>> tuple = new BlockedWebsites().new Tuple<Boolean, List<String>>(Boolean.TRUE, expectedResult);
		assertEquals(tuple, result);
	}
	
	@Test
	public void testSingleSite() {
		String[] words = new String[]{"+ codeforces"};
		Tuple<Boolean, List<String>> result = new BlockedWebsites().findPrefix(words);
		result = new BlockedWebsites().findPrefix(words);
		List<String> expectedResult = new ArrayList<String>();
		Tuple<Boolean, List<String>> tuple = new BlockedWebsites().new Tuple<Boolean, List<String>>(Boolean.TRUE, expectedResult);
		assertEquals(tuple, result);
	}
	
	@Test
	public void testNegativeCase() {
		String[] words = new String[]{"- codeforces", "+ codeforces"};
		Tuple<Boolean, List<String>> result = new BlockedWebsites().findPrefix(words);
		List<String> expectedResult = new ArrayList<String>();
		Tuple<Boolean, List<String>> tuple = new BlockedWebsites().new Tuple<Boolean, List<String>>(Boolean.FALSE, expectedResult);
		System.out.println(result);
		assertEquals(Boolean.FALSE, result.x);
	}
	
	@Test
	public void testSomething() {
		String[] words = new String[]{"- codeforces","- codechef", "+ codefame","+ youtube","- google"};
		Tuple<Boolean, List<String>> result = new BlockedWebsites().findPrefix(words);
		List<String> expectedResult = new ArrayList<String>(){{add("codec");add("codefo");add("g");}};
		Tuple<Boolean, List<String>> tuple = new BlockedWebsites().new Tuple<Boolean, List<String>>(Boolean.TRUE, expectedResult);
		assertEquals(tuple, result);
	}
	
	@Test
	public void testNoSolution() {
		String[] words = new String[]{"- codechef","+ codechef"};
		Tuple<Boolean, List<String>> result = new BlockedWebsites().findPrefix(words);
		List<String> expectedResult = new ArrayList<String>();
		Tuple<Boolean, List<String>> tuple = new BlockedWebsites().new Tuple<Boolean, List<String>>(Boolean.TRUE, expectedResult);
		assertEquals(Boolean.FALSE, result.x);
	}

}
