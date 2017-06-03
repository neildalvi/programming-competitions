package core.input.graph.basic;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Reachability {
    protected static int reach(ArrayList<Integer>[] adj, int x, int y) {
    	boolean[] visited = new boolean[adj.length+1];
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
    	if(visited[y])
    		return 1;
        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

