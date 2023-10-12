package task02;

public class christmasTree {
	public static void drawChristmasTree(int row) {
		if (row < 1) {
			return;
		}
		for (int i = 1; i <= row; i++) {
			drawPyramid(i, row);
		}
	}

	public static void drawPyramid(int n, int row) {
		if (n < 1) {
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = i; j < row - 1; j++) {
				System.out.print(" ");
			}
			// In "X"
			int width = i + (i % n);
			for (int k = 0; k <= width; k++) {
				System.out.print("X");
			}
			// Di chuyển đến hàng tiếp theo
			System.out.println();
		}
	}

	public static void main(String[] args) {
		drawChristmasTree(4);
	}
}
