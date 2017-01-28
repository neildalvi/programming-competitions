package codechef.challenge.jan2017;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.Test;

public class CapitalMovementTest3 {

	/*@Test
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
*/	
	/*@Test(timeout=40000)
	public void test5000() {
	
		int n = 50000;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		int[] planet = new int[n+1];
		for (int i = 1; i <= n; i++) {
			planet[i] = i+10;
		}
		Set<Integer>[] portal = new Set[n+1];
		for (int i = 0; i <= n; i++) {
			portal[i] = new HashSet<Integer>();
			portal[i].add(planet[i]);
		}
		for (int i = 1; i < n; i++) {
			int u = n;
			int v = i;
			portal[u].add(planet[v]);
			portal[v].add(planet[u]);
		}
		CapitalMovement3.solve(portal, planet, heap);
	}
*/
}
