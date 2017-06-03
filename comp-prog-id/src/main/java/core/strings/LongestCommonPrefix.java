package core.strings;

public class LongestCommonPrefix {

	private int findMinLength(String[] words) {
		int length = Integer.MAX_VALUE;
		for (String str : words) {
			length = Math.min(length, str.length());
		}
		return length;
	}

	private boolean allContainsPrefix(String[] words, String commonStr, int start, int end) {
		for (String word : words) {
			for (int i = start; i <= end; i++) {
				if (word.charAt(i) != commonStr.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}

	private String calcCommonPrefix(String[] words) {
		int index = findMinLength(words) - 1;

		int low = 0, high = index;
		String prefix = "";
		while (low <= high) {
			int mid = (low + high) / 2;
			if (allContainsPrefix(words, words[0], low, mid)) {
				prefix = prefix + words[0].substring(low, mid + 1);
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return prefix;
	}

	public static void main(String[] args) {
		//String[] words = new String[] { "geeksforgeeks", "geeks", "geek", "geekszer" };
		String[] words = new String[] { "codechef", "codeforces" };
		System.out.println(new LongestCommonPrefix().calcCommonPrefix(words));
	}
}
