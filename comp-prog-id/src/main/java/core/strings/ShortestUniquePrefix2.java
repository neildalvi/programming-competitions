package core.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestUniquePrefix2 {

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

	private void findPrefixesUtil(TrieNode root, char prefix[], int index, List<String> result) {
		if (root == null)
			return;
		if (root.frequency == 0 && root.blockedFrequency == 1) {
			result.add(new String(prefix));
			return;
		}
		for (int i = 0; i < 26; i++) {
			if (root.child[i] != null) {
				prefix[index] = (char) (i + 'a');
				findPrefixesUtil(root.child[i], prefix, index + 1, result);
				prefix[index] = Character.MIN_VALUE;
			}
		}
	}

	private List<String> findPrefix(String[] word) {
		TrieNode root = new TrieNode(false);
		root.frequency = 0;
		for (int i = 0; i < word.length; i++) {
			insert(root, word[i]);
		}
		//System.out.println(root);
		char[] prefix = new char[20];
		List<String> result = new ArrayList<String>();
		findPrefixesUtil(root, prefix, 0, result);
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String[] words = new String[t];
		while(--t >=0) {
			words[t] = br.readLine();
		}
		List<String> result = new ShortestUniquePrefix2().findPrefix(words);
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		for(String ans : result) {
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
