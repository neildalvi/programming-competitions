package codechef.challenge.jan2017;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.junit.Test;

public class CapitalMovementLinearTest {

	@Test
	public void test1() {
		int n = 2;
		@SuppressWarnings("unchecked")
		List<Integer>[] portal = new List[n];
		for (int i = 0; i < portal.length; i++) {
			portal[i] = new ArrayList<>();
			portal[i].add(i);
		}
		int[] planet = new int[n];
		planet[1] = 5;
		TreeMap<Integer, Integer> heap = new TreeMap<>();
		for (int i = 1; i < planet.length; i++) {
			heap.put(planet[i], i);
		}
		assertEquals("0\n", CapitalMovementLinear.solve(new StringBuilder(), portal, planet, heap).toString());
	}

	@Test
	public void test2() {
		int n = 3;
		@SuppressWarnings("unchecked")
		List<Integer>[] portal = new List[n];
		for (int i = 0; i < portal.length; i++) {
			portal[i] = new ArrayList<>();
			portal[i].add(i);
		}
		portal[1].add(2);
		portal[2].add(1);
		int[] planet = new int[n];
		planet[1] = 5;
		planet[2] = 10;
		TreeMap<Integer, Integer> heap = new TreeMap<>();
		for (int i = 1; i < planet.length; i++) {
			heap.put(planet[i], i);
		}
		assertEquals("0 0\n", CapitalMovementLinear.solve(new StringBuilder(), portal, planet, heap).toString());
	}

	@Test
	public void testNebInConnWithMax1() {
		int n = 6;
		@SuppressWarnings("unchecked")
		List<Integer>[] portal = new List[n];
		for (int i = 0; i < portal.length; i++) {
			portal[i] = new ArrayList<>();
			portal[i].add(i);
		}
		portal[1].add(2);
		portal[1].add(3);
		portal[2].add(1);
		portal[3].add(1);
		portal[3].add(4);
		portal[4].add(5);
		portal[4].add(3);
		portal[5].add(4);
		int[] planet = new int[n];
		planet[1] = 30;
		planet[2] = 15;
		planet[3] = 5;
		planet[4] = 25;
		planet[5] = 20;
		TreeMap<Integer, Integer> heap = new TreeMap<>();
		for (int i = 1; i < planet.length; i++) {
			heap.put(planet[i], i);
		}
		assertEquals("4 4 5 1 1\n", CapitalMovementLinear.solve(new StringBuilder(), portal, planet, heap).toString());
	}

	@Test
	public void testNebInConnWithMax2() {
		int n = 5;
		@SuppressWarnings("unchecked")
		List<Integer>[] portal = new List[n];
		for (int i = 0; i < portal.length; i++) {
			portal[i] = new ArrayList<>();
			portal[i].add(i);
		}
		portal[1].add(2);
		portal[1].add(3);
		portal[2].add(1);
		portal[3].add(1);
		portal[3].add(4);
		portal[4].add(3);
		int[] planet = new int[n];
		planet[1] = 30;
		planet[2] = 15;
		planet[3] = 5;
		planet[4] = 25;
		TreeMap<Integer, Integer> heap = new TreeMap<>();
		for (int i = 1; i < planet.length; i++) {
			heap.put(planet[i], i);
		}
		assertEquals("4 4 2 1\n", CapitalMovementLinear.solve(new StringBuilder(), portal, planet, heap).toString());
	}

	@Test
	public void testNebInConnWithMax3() {
		int n = 5;
		@SuppressWarnings("unchecked")
		List<Integer>[] portal = new List[n];
		for (int i = 0; i < portal.length; i++) {
			portal[i] = new ArrayList<>();
			portal[i].add(i);
		}
		portal[1].add(2);
		portal[1].add(3);
		portal[2].add(1);
		portal[3].add(1);
		portal[3].add(4);
		portal[4].add(3);
		int[] planet = new int[n];
		planet[1] = 30;
		planet[2] = 15;
		planet[3] = 5;
		planet[4] = 10;
		TreeMap<Integer, Integer> heap = new TreeMap<>();
		for (int i = 1; i < planet.length; i++) {
			heap.put(planet[i], i);
		}
		assertEquals("4 4 2 1\n", CapitalMovementLinear.solve(new StringBuilder(), portal, planet, heap).toString());
	}

	@Test
	public void testNebInConnWithMax4() {
		int n = 6;
		@SuppressWarnings("unchecked")
		List<Integer>[] portal = new List[n];
		for (int i = 0; i < portal.length; i++) {
			portal[i] = new ArrayList<>();
			portal[i].add(i);
		}
		portal[1].add(2);
		portal[1].add(3);
		portal[2].add(1);
		portal[3].add(1);
		portal[3].add(4);
		portal[2].add(5);
		int[] planet = new int[n];
		planet[1] = 30;
		planet[2] = 15;
		planet[3] = 5;
		planet[4] = 10;
		planet[5] = 25;
		TreeMap<Integer, Integer> heap = new TreeMap<>();
		for (int i = 1; i < planet.length; i++) {
			heap.put(planet[i], i);
		}
		assertEquals("5 4 5 1 1\n", CapitalMovementLinear.solve(new StringBuilder(), portal, planet, heap).toString());
	}

	@Test
	public void test() {
		int n = 7;
		@SuppressWarnings("unchecked")
		List<Integer>[] portal = new List[n];
		for (int i = 0; i < portal.length; i++) {
			portal[i] = new ArrayList<>();
		}
		int[] planet = new int[n];
		// portal[1].addAll()
	}

}
