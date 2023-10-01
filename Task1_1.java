package task01;

public class Task1_1 {
	public static int getSn1(int n) {
		if (n == 0) {
			return 0;
		} else {
			return (int) (Math.pow(-1, n + 1) * n + getSn1(n - 1));
		}
	}

	public static int giaiThua(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * giaiThua(n - 1);
		}
	}

	public static int getSn2(int n) {
		if (n == 0) {
			return 0;
		} else {
			return giaiThua(n) + getSn2(n - 1);
		}
	}

	public static int getSn3(int n) {
		if (n == 0) {
			return 0;
		} else {
			return (int) (Math.pow(n, 2) + getSn3(n - 1));
		}
	}

	public static double mauSo(int n) {
		if (n == 0) {
			return 1;
		} else {
			return (int) ((double) 2 * n * mauSo(n - 1));
		}
	}

	public static double getSn4(int n) {
		if (n == 0) {
			return 0;
		} else {
			return 1 / mauSo(n) + getSn4(n - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(getSn1(12));
		System.out.println(getSn2(3));
		System.out.println(getSn3(3));
		System.out.println(getSn4(3));
	}
}
