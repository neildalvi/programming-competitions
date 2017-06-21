package codechef.challenge.june2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChefAndTheFeast {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			long positive = 0, count = 0;
			List<Integer> neg = new ArrayList<Integer>();
			br.readLine();
			String[] words = br.readLine().split(" ");
			for (int i = 0; i < words.length; i++) {
				int a = Integer.parseInt(words[i]);
				if (a >= 0) {
					positive += a;
					count++;
				} else {
					neg.add(a);
				}
			}
			Collections.sort(neg);
			long negative = 0;
			for (int i = neg.size() - 1; i >= 0; i--) {
				if (positive + (count + 1) * neg.get(i) >= 0) {
					positive += neg.get(i);
					count++;
				} else {
					negative += neg.get(i);
				}
			}
			System.out.println(positive * count + negative);
		}
	}
}
