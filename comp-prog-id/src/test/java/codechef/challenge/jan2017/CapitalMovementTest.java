package codechef.challenge.jan2017;

import static org.junit.Assert.*;

import org.junit.Test;

import codechef.challenge.jan2017.CapitalMovement.Planet;

public class CapitalMovementTest {
	
	@Test
	public void test1Planets() {
		Integer[][] portal = new Integer[][]{};
		Planet[] planets = new Planet[]{
				new CapitalMovement().new Planet(10, 1),
		};
		assertEquals("0", CapitalMovement.solve(portal, planets));
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

}
