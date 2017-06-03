package core.input.graph.basic;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ReachabilityTest extends Reachability{

	@SuppressWarnings("serial")
	@Test
	public void testReachSuccess() {
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[4];
		adj[0] = new ArrayList<Integer>(){{add(1);add(3);}};
		adj[1] = new ArrayList<Integer>(){{add(0);add(2);}};
		adj[2] = new ArrayList<Integer>(){{add(1);add(3);}};
		adj[3] = new ArrayList<Integer>(){{add(2);add(0);}};
		int connected = Reachability.reach(adj, 0, 3);
		Assert.assertEquals(1, connected);
	}
	
	@SuppressWarnings("serial")
	@Test
	public void testReachFailure() {
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[4];
		adj[0] = new ArrayList<Integer>(){{add(1);}};
		adj[1] = new ArrayList<Integer>(){{add(0);add(2);}};
		adj[2] = new ArrayList<Integer>(){{add(1);}};
		adj[3] = new ArrayList<Integer>();
		int connected = Reachability.reach(adj, 0, 3);
		Assert.assertEquals(0, connected);
	}

}
