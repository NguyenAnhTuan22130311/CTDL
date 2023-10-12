package task01;

import java.util.Arrays;

public class PascalTriagle {
	public static void printPascalTriagle(int row) {
		for (int i = 0; i < row; i++) {
			System.out.println(Arrays.toString(getPascalTriagle(i)));
		}
	}

	public static int[] getPascalTriagle(int n) {
		if (n == 0) {
			return new int[] { 1 };
		} else {
			int[] prewRow = getPascalTriagle(n - 1);
			return generateNextRow(prewRow);
		}
	}

	public static int[] generateNextRow(int[] prewRow) {
		int[] res = new int[prewRow.length + 1];
		res[0] = 1;
		res[prewRow.length] = 1;
		for (int i = 1; i < res.length - 1; i++) {
			res[i] = prewRow[i] + prewRow[i - 1];
		}
		return res;
	}

	public static void main(String[] args) {
		printPascalTriagle(5);
	}
}
