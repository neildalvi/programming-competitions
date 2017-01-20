package core.input;

import java.io.BufferedInputStream;
import java.io.IOException;

public class FastReader {

	public int readInt() throws IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		int input = bis.read();
		while(!checkIfNumber(input)) {
			input = bis.read();
		}
		int number = input;
		input = bis.read();
		while(checkIfNumber(input)) {
			number = 10*number + input;
			input = bis.read();
		}
		return number;
	}
	
	private boolean checkIfNumber(int input) {
		if(input >= '0' && input <=9 ) {
			return true;
		}
		return false;
	}
}
