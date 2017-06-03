package codechef.challenge.may2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class CoursesInAnUniversity {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			int n = Integer.parseInt(br.readLine());
			String[] prerequisite = br.readLine().split(" ");
			int result = calcCoursesWithNoDependency(n, prerequisite);
			System.out.println(result);
		}
	}

	public static int calcCoursesWithNoDependency(int n, String[] prerequisite) {
		Set<String> dependency = new HashSet<String>();
		int nonePreReq = 0;
		int withPreReq = 0;
		for (String prereq : prerequisite) {
			int temp = Integer.parseInt(prereq);
				withPreReq = Math.max(withPreReq, temp);
		}
		int result = n - withPreReq;
		return result;
	}

}
