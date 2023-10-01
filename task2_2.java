package task02;

public class task2_2 {
	public static void drawPyramidPattern03(int n) {
		drawPyramidRow(n, 1);
	}

	public static void drawPyramidRow(int n, int row) {
		// In khoảng trắng trước "x"
		if (row > n) {
			return;
		}
		for (int i = n - row; i > 0; i--) {
			System.out.print(" ");
		}
		// In "X"
		for (int j = 1; j <= row * 2 - 1; j++) {
			System.out.print("*");
		}
		// Di chuyển đến hàng tiếp theo
		System.out.println();
		drawPyramidRow(n, row + 1);
	}

	public static void main(String[] args) {
		drawPyramidPattern03(4);
	}
}
