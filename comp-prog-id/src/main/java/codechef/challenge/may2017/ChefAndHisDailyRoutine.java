package codechef.challenge.may2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChefAndHisDailyRoutine {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			String s = br.readLine();
			char oneBefore = s.charAt(0);
			StringBuilder sb = new StringBuilder();
			sb.append(oneBefore);
			for (char oneAfter : s.toCharArray()) {
				if (oneBefore != oneAfter) {
					sb.append(oneAfter);
				}
				oneBefore = oneAfter;
			}
			System.out.println(isValidOrder(sb.toString()) ? "yes" : "no");
		}
	}

	public static boolean isValidOrder(String eventSequence) {
		String[] validSequences = new String[] {"C","CE","CES","CS","E","ES","S"};
		List<String> list = Arrays.asList(validSequences);
		if(Collections.binarySearch(Arrays.asList(validSequences), eventSequence) >= 0) {
			return true;
		}
		return false;
	}
}
