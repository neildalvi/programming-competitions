package codechef.challenge.june2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XennyAndCoinXchangeRankings {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			String[] words = br.readLine().split(" ");
			long a = Long.parseLong(words[0]);
			long b = Long.parseLong(words[1]);
			long result = (((a + 1) * (a + 2)) / 2) + a * b + b * (b + 1) / 2;
			System.out.println(result);
		}
	}
}
