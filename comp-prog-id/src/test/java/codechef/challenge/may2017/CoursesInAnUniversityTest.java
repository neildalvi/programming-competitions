package codechef.challenge.may2017;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoursesInAnUniversityTest {
	
	int n;
	String[] st;

	@Test
	public void testGivenExample1() {
		n = 3;
		st = ("0 1 1").split(" ");
		int actualResult = CoursesInAnUniversity.calcCoursesWithNoDependency(n, st);
		assertEquals(2, actualResult);
	}

	@Test
	public void testGivenExample2() {
		n = 3;
		st = ("0 1 2").split(" ");
		int actualResult = CoursesInAnUniversity.calcCoursesWithNoDependency(n, st);
		assertEquals(1, actualResult);
	}
	
	@Test
	public void testGivenExample3() {
		n = 5;
		st = ("0 0 0 0 4").split(" ");
		int actualResult = CoursesInAnUniversity.calcCoursesWithNoDependency(n, st);
		assertEquals(1, actualResult);
	}

}
