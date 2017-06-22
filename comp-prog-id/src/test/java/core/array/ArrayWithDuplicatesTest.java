package core.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class ArrayWithDuplicatesTest {

	@Test
	public void test() {
		List<Integer> A = new ArrayList<Integer>() {
			{
				add(1);
				add(1);
				add(2);
			}
		};
		ArrayWithDuplicates.deleteDuplicates(A);
		Assert.assertEquals(new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(2);
			}
		}, A);

		A = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
			}
		};
		ArrayWithDuplicates.deleteDuplicates(A);
		Assert.assertEquals(new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
			}
		}, A);
	}

}
