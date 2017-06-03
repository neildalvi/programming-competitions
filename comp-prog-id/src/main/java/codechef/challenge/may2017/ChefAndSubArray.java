package codechef.challenge.may2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;


public class ChefAndSubArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int P = Integer.parseInt(input[2]);
		String[] sequence = br.readLine().split(" ");
		System.out.println(calc(N, K, P, sequence, br.readLine().toCharArray()));
	}

	public static String calc(int N, int K, int P, String[] sequence, char[] operations) {
		K = Math.min(K, N);

		TreeMap<Integer, Set<Node>> maxMap = new TreeMap<Integer, Set<Node>>();

		int tmpCountOfOnes = 0;
		char tmpLastBit = sequence[N - 1].charAt(0);
		for (int i = 0; i < K - 1; i++) {
			if (sequence[i].equals("1")) {
				tmpCountOfOnes++;
			}
		}
		Node previousNode = null;
		Node firstNode = null;
		Node lastNode = null;
		for (int i = K - 1; i < sequence.length; i++) {
			tmpLastBit = sequence[i].charAt(0);
			if (sequence[i].equals("1")) {
				tmpCountOfOnes++;
			}
			Node newNode = new ChefAndSubArray().new Node(tmpCountOfOnes, tmpLastBit, previousNode);

			if (maxMap.containsKey(tmpCountOfOnes)) {
				Set<Node> nodes = maxMap.get(tmpCountOfOnes);
				nodes.add(newNode);
				maxMap.put(tmpCountOfOnes, nodes);
			} else {
				maxMap.put(tmpCountOfOnes, new HashSet<Node>() {
					{
						add(newNode);
					}
				});
			}
			previousNode = newNode;
			if (i == K - 1) {
				firstNode = newNode;
			}
			if (sequence[i - K + 1].equals("1")) {
				tmpCountOfOnes--;
			}
		}
		lastNode = previousNode;

		//printNodeList(lastNode);
		StringBuilder result = new StringBuilder();
		int rotated = 0;
		for (char operation : operations) {
			if (operation == '?') {
				result.append(maxMap.lastKey()).append("\n");
			} else {
				rotated++;
				Node penUltimateNode = lastNode.nextNode;

				int newCount = firstNode.countOfOnes;
				if (firstNode.lastBit == '1') {
					newCount--;
				}
				if (lastNode.lastBit == '1') {
					newCount++;
				}
				Node newNode = new ChefAndSubArray().new Node(newCount, sequence[nextLink(K, rotated, N)].charAt(0), null);
				
				Set<Node> nodes = maxMap.get(lastNode.countOfOnes);
				nodes.remove(lastNode);
				if (nodes.size() != 0) {
					maxMap.put(lastNode.countOfOnes, nodes);
				} else {
					maxMap.remove(lastNode.countOfOnes);
				}
				
				if (maxMap.containsKey(newCount)) {
					Set<Node> tnodes = maxMap.get(newCount);
					tnodes.add(newNode);
					maxMap.put(newCount, tnodes);
				} else {
					maxMap.put(newCount, new HashSet<Node>() {
						{
							add(newNode);
						}
					});
				}

				firstNode.nextNode = newNode;
				firstNode = newNode;
				if(penUltimateNode == null) {
					lastNode = firstNode;
				} else {
					lastNode = penUltimateNode;
				}

				//printNodeList(lastNode);
			}
		}

		return result.toString();
	}

	private static int nextLink(int K, int rotated, int N) {
		int next = (K - 1 - rotated)%N;
		if (next < 0) {
			next += N;
		}
		return next;
	}

	private static void printNodeList(Node lastNode) {
		System.out.println("------------------------------");
		Node tmp = lastNode;
		while (tmp != null) {
			System.out.println(tmp);
			tmp = tmp.nextNode;
		}
	}

	class Node {
		int countOfOnes;
		char lastBit;
		Node nextNode;

		public Node(int countOfOnes, char lastBit, Node nextNode) {
			super();
			this.countOfOnes = countOfOnes;
			this.lastBit = lastBit;
			this.nextNode = nextNode;
		}

		@Override
		public String toString() {
			return "Node [countOfOnes=" + countOfOnes + ", lastBit=" + lastBit + ", nextNode=" + nextNode + "]";
		}

	}

}
