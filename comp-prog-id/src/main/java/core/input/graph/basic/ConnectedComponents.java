package core.input.graph.basic;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ConnectedComponents {
	protected static int numberOfComponents(ArrayList<Integer>[] adj) {
		int result = 0;
		boolean[] visited = new boolean[adj.length + 1];
		Stack<Integer> stack = new Stack<>();
		for (int x = 0; x < adj.length; x++) {
			if(visited[x])
				continue;
			result++;
			reach(adj, visited, x);
		}
		return result;
	}
	
	protected static void reach(ArrayList<Integer>[] adj, boolean[] visited, int x) {
    	visited[x] = true;
    	Stack<Integer> stack = new Stack<>();
    	stack.push(x);
    	while(!stack.isEmpty()) {
    		int elem = stack.pop();
    		for(int neb : adj[elem]) {
    			if(!visited[neb]) {
    				visited[neb] = true;
    				stack.push(neb);
    			}
    		}
    	}
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int x, y;
			x = scanner.nextInt();
			y = scanner.nextInt();
			adj[x - 1].add(y - 1);
			adj[y - 1].add(x - 1);
		}
		System.out.println(numberOfComponents(adj));
	}
}
