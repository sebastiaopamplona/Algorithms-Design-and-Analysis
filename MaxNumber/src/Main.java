import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.MaxNumber;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int nChildren = Integer.parseInt(reader.readLine());

		MaxNumber mn = new MaxNumber();
		
		while (nChildren > 0) {

			mn.solveMaxNumber(reader.readLine());

			nChildren--;
		}

		System.out.println(mn.getBiggestNumber());
	}
}
