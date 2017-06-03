package codechef.lunchtime.jan2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Code1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int count;
		while (--t >= 0) {
			count = 0;
			String[] words = br.readLine().split(" ");
			int n = Integer.parseInt(words[0]);
			int m = Integer.parseInt(words[1]);
			Set<Integer> set = new HashSet<Integer>(n);
			words = br.readLine().split(" ");
			for (int i = 0; i < words.length; i++) {
				set.add(Integer.parseInt(words[i]));
			}
			words = br.readLine().split(" ");
			for (int i = 0; i < words.length; i++) {
				if(set.contains(Integer.parseInt(words[i]))){
					count++;
				}
			}
			System.out.println(count);
			
		}
	}

}
