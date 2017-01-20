package codechef.challenge.jan2017;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reservoir {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		int t = readInt(bis);
		StringBuffer sb = new StringBuffer();
		while (--t >= 0) {
			boolean statbleCheck = solve(bis);
			sb.append(statbleCheck ? "yes" : "no").append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean solve(BufferedInputStream bis) throws IOException {
		int h = readInt(bis);
		int w = readInt(bis);
		char[] prev = new char[w + 2];
		char[] now = new char[w + 2];
		boolean statbleCheck = true;
		for (int i = 0; i < h; i++) {
			for (int j = 1; j <= w; j++) {
				now[j] = readChar(bis);
				if (!checkOnSameLevel(now[j - 1], now[j])) {
					statbleCheck = false;
				}
				if (!checkOnDiffLevel(prev[j], now[j])) {
					statbleCheck = false;
				}
			}
			if (now[w] == 'W') {
				statbleCheck = false;
			}
			prev = now;
			now = new char[w + 2];
		}
		return statbleCheck;
	}

	static boolean checkOnSameLevel(char c1, char c2) {
		if ((c1 == 'W' && c2 == 'A') || (c1 == 'A' && c2 == 'W') || (c1 == 'W' && c2 == 0) || (c1 == 0 && c2 == 'W'))
			return false;
		return true;
	}

	static boolean checkOnDiffLevel(char top, char down) {
		if ((top == 'W' && down == 'A') || (top == 'B' && down == 'A') || (top == 'B' && down == 'W'))
			return false;
		return true;
	}

	public static char readChar(BufferedInputStream bis) throws IOException {
		int input = bis.read();
		while (!(input == 'W' || input == 'B' || input == 'A')) {
			input = bis.read();
		}
		return (char) input;
	}

	public static int readInt(BufferedInputStream bis) throws IOException {
		int input = bis.read();
		while (!checkIfNumber(input)) {
			input = bis.read();
		}
		int number = input - 48;
		input = bis.read();
		while (checkIfNumber(input)) {
			number = 10 * number + input - 48;
			input = bis.read();
		}
		return number;
	}

	private static boolean checkIfNumber(int input) {
		if (input >= 48 && input <= 57) {
			return true;
		}
		return false;
	}

}
