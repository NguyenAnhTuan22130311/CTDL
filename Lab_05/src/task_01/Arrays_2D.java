package task_01;

public class Arrays_2D {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		// Kiểm tra xem 2 ma trận có cùng kích thước hay không
		if (a.length != b.length || a[0].length != b[0].length)
			return null;

		// Khởi tạo 1 ma trận mới để lưu kết quả
		int[][] result = new int[a.length][a[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}

	// subtract 2 matrices
	public static int[][] subtract(int[][] a, int[][] b) {
		// Kiểm tra xem 2 ma trận có cùng kích thước hay không
		if (a.length != b.length || a[0].length != b[0].length)
			return null;

		// Khởi tạo 1 ma trận mới để lưu kết quả
		int[][] result = new int[a.length][a[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = a[i][j] - b[i][j];
			}
		}
		return result;
	}

	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		// Kiểm tra xem 2 ma trận có thỏa điều kiện không
		if (a[0].length != b.length)
			return null;

		int[][] result = new int[a.length][b[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				// Tính tổng của các tích của cả 2 ma trận
				int sum = 0;
				for (int k = 0; k < a[0].length; k++) {
					sum += a[i][k] * b[k][j];
				}
				result[i][j] = sum;
			}
		}
		return result;
	}
	
	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int[][] reusult = new int[a[0].length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				reusult[j][i] = a[i][j];
			}
		}
		return reusult;
	}

	public static void main(String[] args) {
		int[][] array1 = { { 7, 2 }, { 5, 3 } };
		int[][] array2 = { { 2, 1 }, { 3, 1 } };
		int[][] array3 = { { 1, 2, 3, 9 }, { 4, 5, 6, 13 } };
		int[][] array4 = { { 7, 8, -3 }, { 9, 10, -7 }, { 11, 12, 2 }, { 5, 0, 0, 2 } };
		int[][] resultAdd = add(array1, array2);
		int[][] resultSubtract = subtract(array1, array2);
		int[][] resultMultiply = multiply(array3, array4);
		int[][] resultTranspose = transpose(array3);
		System.out.println("Add: ");
		for (int i = 0; i < resultAdd.length; i++) {
			for (int j = 0; j < resultAdd[i].length; j++) {
				System.out.print(resultAdd[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Subtract: ");
		for (int i = 0; i < resultSubtract.length; i++) {
			for (int j = 0; j < resultSubtract[i].length; j++) {
				System.out.print(resultSubtract[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Multiply: ");
		for (int i = 0; i < resultMultiply.length; i++) {
			for (int j = 0; j < resultMultiply[i].length; j++) {
				System.out.print(resultMultiply[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Transpose: ");
		for (int i = 0; i < resultTranspose.length; i++) {
			for (int j = 0; j < resultTranspose[i].length; j++) {
				System.out.print(resultTranspose[i][j] + " ");
			}
			System.out.println();
		}
	}
}
