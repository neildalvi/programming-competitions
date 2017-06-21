package codechef.challenge.june2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AGoodSet {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 1, k = 1; k <= n; i += 2, k++) {
				sb.append(i).append(" ");
			}
			System.out.println(sb.toString());
		}
	}
}
