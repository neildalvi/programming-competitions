package codechef.cookoff.jan2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s = br.readLine();
			s = s.replace(" ", "");
			System.out.println(s);
		}
	}

}
