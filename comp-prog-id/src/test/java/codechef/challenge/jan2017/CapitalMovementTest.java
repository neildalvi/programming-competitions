package codechef.challenge.jan2017;

import static org.junit.Assert.*;

import org.junit.Test;

public class CapitalMovementTest {

	@Test
	public void test1Planets() {
		Integer[][] portal = new Integer[][] {};
		int[] planets = new int[] { 10 };
		assertEquals("0", CapitalMovement.solve(portal, planets));
	}

	@Test
	public void test2Planets() {
		Integer[][] portal = new Integer[][] { { 1, 2 }, { 2, 1 } };
		int[] planets = new int[] { 20, 10 };
		assertEquals("0 0", CapitalMovement.solve(portal, planets));
	}

	@Test
	public void test3Planets() {
		Integer[][] portal = new Integer[][] { { 1, 2 }, { 2, 1 }, { 2, 3 }, { 3, 2 } };
		int[] planets = new int[] { 10, 20, 30 };
		assertEquals("3 0 1", CapitalMovement.solve(portal, planets));
	}

	@Test
	public void test4PlanetsChain() {
		Integer[][] portal = new Integer[][] { { 1, 2 }, { 2, 1 }, { 2, 3 }, { 3, 2 }, { 3, 4 }, { 4, 3 } };
		int[] planets = new int[] { 10, 20, 30, 40 };
		assertEquals("4 4 1 2", CapitalMovement.solve(portal, planets));
		planets = new int[] { 10, 20, 40, 30 };
		assertEquals("3 4 1 2", CapitalMovement.solve(portal, planets));
		planets = new int[] { 40, 30, 20, 10 };
		assertEquals("3 4 1 1", CapitalMovement.solve(portal, planets));
	}

	@Test
	public void test4PlanetsDiamond() {
		Integer[][] portal = new Integer[][] { { 1, 2 }, { 2, 1 }, { 1, 3 }, { 3, 1 }, { 1, 4 }, { 4, 1 } };
		int[] planets = new int[] { 10, 20, 30, 40 };
		assertEquals("0 4 4 3", CapitalMovement.solve(portal, planets));
		planets = new int[] { 40, 20, 30, 10 };
		assertEquals("0 3 2 3", CapitalMovement.solve(portal, planets));
	}

	@Test
	public void test5PlanetsDiamond() {
		Integer[][] portal = new Integer[][] { { 1, 2 }, { 2, 1 }, { 1, 3 }, { 3, 1 }, { 1, 4 }, { 4, 1 }, { 4, 5 },
				{ 5, 4 } };
		int[] planets = new int[] { 10, 20, 30, 40, 50 };
		assertEquals("5 5 5 3 3", CapitalMovement.solve(portal, planets));
		planets = new int[] { 50, 20, 30, 10, 40 };
		assertEquals("5 5 5 3 1", CapitalMovement.solve(portal, planets));
		planets = new int[] { 10, 20, 30, 50, 40 };
		assertEquals("5 4 4 3 3", CapitalMovement.solve(portal, planets));
	}

	@Test
	public void test6SymPlanets() {
		Integer[][] portal = new Integer[][] { { 1, 2 }, { 2, 1 }, { 1, 3 }, { 3, 1 }, { 1, 4 }, { 4, 1 }, { 4, 5 },
				{ 5, 4 }, { 4, 6 }, { 6, 4 } };
		int[] planets = new int[] { 10, 20, 30, 40, 50, 60 };
		assertEquals("6 6 6 3 6 5", CapitalMovement.solve(portal, planets));
		planets = new int[] { 10, 20, 30, 60, 50, 40 };
		assertEquals("5 4 4 3 6 5", CapitalMovement.solve(portal, planets));
	}

	@Test
	public void test6EPlanetsDiamond() {
		Integer[][] portal = new Integer[][] { { 1, 2 }, { 3, 5 }, { 5, 3 }, { 2, 1 }, { 1, 3 }, { 4, 3 }, { 5, 6 },
				{ 6, 5 }, { 3, 1 }, { 3, 4 } };
		int[] planets = new int[] { 10, 20, 30, 40, 50, 60 };
		assertEquals("6 6 6 6 4 4", CapitalMovement.solve(portal, planets));
		planets = new int[] { 10, 20, 30, 40, 60, 50 };
		assertEquals("5 5 6 5 4 4", CapitalMovement.solve(portal, planets));
		planets = new int[] { 10, 20, 30, 60, 50, 40 };
		assertEquals("4 4 6 5 4 4", CapitalMovement.solve(portal, planets));
		planets = new int[] { 10, 20, 60, 30, 50, 40 };
		assertEquals("5 3 6 5 4 3", CapitalMovement.solve(portal, planets));
	}
	
	@Test(timeout=30000)
	public void test5000() {
		Integer[][] portal = new Integer[100000][2];
		for (int i = 0,j=2; i < portal.length; i++,j++) {
			portal[i][0] = 1; portal[i][1] = j;
			portal[i][0] = j; portal[i][1] = 1;
		}
		int[] planet = new int[50000];
		for (int i = 0; i < planet.length; i++) {
			planet[i] = i + 10;
		}
		CapitalMovement.solve(portal, planet);
	}

}
