package codechef.challenge.jan2017;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reservoir {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
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
		int[] leakPrev = new int[w + 2];
		int[] leakNow = new int[w + 2];
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
				if (i == 0) {
					if (!checkOnTopLevelLeak(prev[j], now[j])) {
						leakNow[j] = 1;
					}
				} else {
					if (!checkOnDiffLevelLeak(prev[j], now[j])) {
						if(leakPrev[j]!=0) {
							leakNow[j] = leakPrev[j];
						} else {
							leakNow[j]=2;
						}
					}
				}
				if (!checkOnSameLevelLeak(now, leakNow, j)) {
					statbleCheck = false;
				}
			}
			for (int j = w; j > 0; j--) {
				if (!checkOnSameLevelLeak(now, leakNow, j)) {
					statbleCheck = false;
				}
			}
			prev = now;
			now = new char[w + 2];
			leakPrev = leakNow;
			leakNow = new int[w + 2];
		}
		return statbleCheck;
	}
	
	

	static boolean checkOnSameLevel(char c1, char c2) {
		if ((c1 == 'W' && c2 == 'A') || (c1 == 'A' && c2 == 'W')
				|| (c1 == 'W' && c2 == 0) || (c1 == 0 && c2 == 'W'))
			return false;
		return true;
	}

	static boolean checkOnDiffLevel(char top, char down) {
		if ((top == 'W' && down == 'A') || (top == 'B' && down == 'A') || (top == 'B' && down == 'W'))
			return false;
		return true;
	}

	static boolean checkOnSameLevelLeak(char[] now, int[] leak, int j) {
		if ((now[j] == 'W' && now[j - 1] == 'W')) {
			if (leak[j] + leak[j - 1] == 3) {
				return false;
			} else if (leak[j - 1] != 0) {
				leak[j] = leak[j - 1];
			} else if (leak[j] != 0) {
				leak[j - 1] = leak[j];
			}
		}
		return true;
	}

	static boolean checkOnTopLevelLeak(char top, char down) {
		if ((top == 0 && down == 'W') || (top == 0 && down == 'A'))
			return false;
		return true;
	}

	static boolean checkOnDiffLevelLeak(char top, char down) {
		if ((top == 'W' && down == 'W') || (top == 'A' && down == 'W')
				|| (top == 'B' && down == 'W')) {
			return false;
		}
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
