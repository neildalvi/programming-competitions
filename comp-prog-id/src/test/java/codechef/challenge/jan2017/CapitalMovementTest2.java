package codechef.challenge.jan2017;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

public class CapitalMovementTest2 {
	
	/*@Test
	public void test1Planets() {
		Integer[][] portal = new Integer[][]{};
		Planet[] planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
		};
		assertEquals("0", CapitalMovement.solve(portal, planets));
		assertEquals("0", CapitalMovementSolnM.solve(portal, new int[]{1}));
	}
	
	@Test
	public void test2Planets() {
		Integer[][] portal = new Integer[][]{{1,2},{2,1}};
		Planet[] planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 1),
		};
		assertEquals("0 0", CapitalMovement.solve(portal, planets));
	}

	@Test
	public void test3Planets() {
		Integer[][] portal = new Integer[][]{{1,2},{2,1},{2,3},{3,2}};
		Planet[] planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
		};
		assertEquals("3 0 1", CapitalMovement.solve(portal, planets));
	}
	
	@Test
	public void test4PlanetsChain() {
		Integer[][] portal = new Integer[][]{{1,2},{2,1},{2,3},{3,2},{3,4},{4,3}};
		Planet[] planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
				new CapitalMovement().new Planet(40, 4),
		};
		assertEquals("4 4 1 2", CapitalMovement.solve(portal, planets));
		planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(40, 3),
				new CapitalMovement().new Planet(30, 4),
		};
		assertEquals("3 4 1 2", CapitalMovement.solve(portal, planets));
		planets = new Planet[]{
				new CapitalMovement().new Planet(30, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(40, 3),
				new CapitalMovement().new Planet(10, 4),
		};
		assertEquals("3 4 1 1", CapitalMovement.solve(portal, planets));
	}
	
	@Test
	public void test4PlanetsDiamond() {
		Integer[][] portal = new Integer[][]{{1,2},{2,1},{1,3},{3,1},{1,4},{4,1}};
		Planet[] planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
				new CapitalMovement().new Planet(40, 4),
		};
		assertEquals("0 4 4 3", CapitalMovement.solve(portal, planets));
		planets = new Planet[]{
				new CapitalMovement().new Planet(40, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
				new CapitalMovement().new Planet(10, 4),
		};
		assertEquals("0 3 2 3", CapitalMovement.solve(portal, planets));
	}
	
	@Test
	public void test5PlanetsDiamond() {
		Integer[][] portal = new Integer[][]{{1,2},{2,1},{1,3},{3,1},{1,4},{4,1},{4,5},{5,4}};
		Planet[] planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
				new CapitalMovement().new Planet(40, 4),
				new CapitalMovement().new Planet(50, 5),
		};
		assertEquals("5 5 5 3 3", CapitalMovement.solve(portal, planets));
		planets = new Planet[]{
				new CapitalMovement().new Planet(50, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
				new CapitalMovement().new Planet(10, 4),
				new CapitalMovement().new Planet(40, 5),
		};
		assertEquals("5 5 5 3 1", CapitalMovement.solve(portal, planets));
		planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
				new CapitalMovement().new Planet(50, 4),
				new CapitalMovement().new Planet(40, 5),
		};
		assertEquals("5 4 4 3 3", CapitalMovement.solve(portal, planets));
	}
	
	@Test
	public void test6SymPlanets() {
		Integer[][] portal = new Integer[][]{{1,2},{2,1},{1,3},{3,1},{1,4},{4,1},{4,5},{5,4},{4,6},{6,4}};
		Planet[] planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
				new CapitalMovement().new Planet(40, 4),
				new CapitalMovement().new Planet(50, 5),
				new CapitalMovement().new Planet(60, 6),
		};
		assertEquals("6 6 6 3 6 5", CapitalMovement.solve(portal, planets));
		planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
				new CapitalMovement().new Planet(60, 4),
				new CapitalMovement().new Planet(50, 5),
				new CapitalMovement().new Planet(40, 6),
		};
		assertEquals("5 4 4 3 6 5", CapitalMovement.solve(portal, planets));
	}
	
	@Test
	public void test6EPlanetsDiamond() {
		Integer[][] portal = new Integer[][] { { 1, 2 }, { 3, 5 }, { 5, 3 }, { 2, 1 }, { 1, 3 }, { 4, 3 }, { 5, 6 },
				{ 6, 5 }, { 3, 1 }, { 3, 4 } };
		Planet[] planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
				new CapitalMovement().new Planet(40, 4),
				new CapitalMovement().new Planet(50, 5),
				new CapitalMovement().new Planet(60, 6),
		};
		assertEquals("6 6 6 6 4 4", CapitalMovement.solve(portal, planets));
		planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
				new CapitalMovement().new Planet(40, 4),
				new CapitalMovement().new Planet(60, 5),
				new CapitalMovement().new Planet(50, 6),
		};
		assertEquals("5 5 6 5 4 4", CapitalMovement.solve(portal, planets));
		planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 3),
				new CapitalMovement().new Planet(60, 4),
				new CapitalMovement().new Planet(50, 5),
				new CapitalMovement().new Planet(40, 6),
		};
		assertEquals("4 4 6 5 4 4", CapitalMovement.solve(portal, planets));
		planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
				new CapitalMovement().new Planet(20, 2),
				new CapitalMovement().new Planet(30, 4),
				new CapitalMovement().new Planet(50, 5),
				new CapitalMovement().new Planet(60, 3),
				
				new CapitalMovement().new Planet(40, 6),
		};
		assertEquals("5 3 6 5 4 3", CapitalMovement.solve(portal, planets));
	}
	
	@Test
	public void testCompare() {
		
		Random random = new Random();
		
		while(true) {
			int n = random.nextInt(10) + 1;
			Integer[][] portal1 = new Integer[n - 1][2];
			Integer[][] portal2 = new Integer[2*n - 2][2];
			int[] planets1 = new int[n];
			Planet[] planets2 = new Planet[n];
			List<Integer> set = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				set.add(i + 1);
			}
			Collections.shuffle(set);
			Integer[] shuffledPlanets = new Integer[n];
			set.toArray(shuffledPlanets);
			for (int i = 0,k=0; i < shuffledPlanets.length - 1; i++,k++) {
				portal1[i][0] = shuffledPlanets[i];
				portal1[i][1] = shuffledPlanets[i + 1];
				portal2[k][0] = shuffledPlanets[i];
				portal2[k][1] = shuffledPlanets[i + 1];
				k++;
				portal2[k][0] = shuffledPlanets[i + 1];
				portal2[k][1] = shuffledPlanets[i];
			}
			for (int i = 0, k = 10; i < planets1.length; i++, k += 10) {
				int pop = random.nextInt(1000000000)+1;
				planets1[i] = pop;
				planets2[i] = new CapitalMovement().new Planet(pop, i + 1);
			}
			if (!CapitalMovement.solve(portal2, planets2).equals(CapitalMovementSolnM.solve(portal1, planets1))) {
				System.out.println(n);
				for (int i = 0; i < planets1.length; i++) {
					System.out.println((i+1) + " = " +planets1[i]);
				}
				for (int i = 0; i < portal1.length; i++) {
					System.out.println(portal1[i][0] + " -> " + portal1[i][1]);
				}
				System.out.println("My : " + CapitalMovement.solve(portal2, planets2));
				System.out.println("Correct : " + CapitalMovementSolnM.solve(portal1, planets1));
				break;
			} else {
				System.out.println("Works!");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
*/
}
