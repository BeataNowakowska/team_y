package virtual.friend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import virtual.friend.exceptions.NoInputException;

public class ConsoleBox {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void write(String line) {
		System.out.println(line);
	}

	public String readline() throws NoInputException {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new NoInputException(e);
		}
	}
	
}
