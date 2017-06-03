package codechef.challenge.may2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockedWebsites {

	class TrieNode {
		TrieNode child[] = new TrieNode[26];
		int frequency = 0;
		int blockedFrequency = 0;

		public TrieNode(boolean blockEnabled) {
			super();
			if (blockEnabled) {
				blockedFrequency = 1;
			} else {
				frequency = 1;
			}
		}

		@Override
		public String toString() {
			return "TrieNode [child=" + Arrays.toString(child).replaceAll("null, ", "") + ", frequency=" + frequency
					+ ", blockedFrequency=" + blockedFrequency + "]";
		}

	}

	private void insert(TrieNode root, String word) {

		TrieNode tmp = root;
		String[] input = word.split(" ");
		boolean blockEnabled = input[0].equals("-");
		for (int i = 0; i < input[1].length(); i++) {
			int ch = input[1].charAt(i) - 'a';
			if (tmp == null) {
				tmp = new TrieNode(blockEnabled);
				tmp.child[ch] = new TrieNode(blockEnabled);
			} else if (tmp.child[ch] == null) {
				tmp.child[ch] = new TrieNode(blockEnabled);
			} else {
				if (blockEnabled) {
					tmp.child[ch].blockedFrequency++;
				} else {
					tmp.child[ch].frequency++;
				}
			}
			tmp = tmp.child[ch];
		}
	}

	private boolean findPrefixesUtil(TrieNode root, char prefix[], int index, Tuple<Boolean, List<String>> tuple, boolean posibility) {
		if (root == null)
			return false;
		if (root.frequency == 0 && root.blockedFrequency == 1) {
			tuple.y.add(new String(prefix).trim());
			return true;
		}
		for (int i = 0; i < 26; i++) {
			if (root.child[i] != null) {
				prefix[index] = (char) (i + 'a');
				if(root.child[i].blockedFrequency > 0) {
					boolean result = findPrefixesUtil(root.child[i], prefix, index + 1, tuple, true);
					tuple.x = result;
				}
				prefix[index] = Character.MIN_VALUE;
			}
		}
		return false;
	}

	Tuple<Boolean, List<String>> findPrefix(String[] word) {
		TrieNode root = new TrieNode(false);
		root.frequency = 0;
		for (int i = 0; i < word.length; i++) {
			insert(root, word[i]);
		}
		//System.out.println(root);
		char[] prefix = new char[20];
		Tuple<Boolean, List<String>> tuple = new Tuple<Boolean, List<String>>(Boolean.TRUE, new ArrayList<String>());
		findPrefixesUtil(root, prefix, 0, tuple, false);
		return tuple;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String[] words = new String[t];
		while (--t >= 0) {
			words[t] = br.readLine();
		}
		Tuple<Boolean, List<String>> result = new BlockedWebsites().findPrefix(words);

		if (!result.x) {
			System.out.println("-1");
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(result.y.size()).append("\n");
			for (String ans : result.y) {
				sb.append(ans).append("\n");
			}
			System.out.print(sb.toString());
		}
	}
	
	/**
	 * @author neild
	 *
	 * @param <X>
	 * @param <Y>
	 */
	class Tuple<X, Y> {
		public X x;
		public final Y y;

		public Tuple(X x, Y y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Tuple [x=" + x + ", y=" + y + "]";
		}

		@Override
		public boolean equals(Object obj) {
			Tuple tuple = (Tuple) obj;
			return(tuple.x.equals(this.x) && this.y.equals(tuple.y));
		}
		
	}
}
