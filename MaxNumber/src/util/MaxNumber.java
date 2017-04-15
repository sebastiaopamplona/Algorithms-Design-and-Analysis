package util;

public class MaxNumber {

	private int biggestNumber;

	public MaxNumber() {
		this.biggestNumber = Integer.MIN_VALUE;
	}

	public void solveMaxNumber(String line) {

		String[] sticks = line.split(" ");

		for (int j = 1; j < sticks.length; j++) {
			if (Integer.parseInt(sticks[j]) > biggestNumber) {
				biggestNumber = Integer.parseInt(sticks[j]);
			}
		}
	}

	public int getBiggestNumber() {
		return biggestNumber;
	}
}
