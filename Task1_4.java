package task01;

public class Task1_4 {
	public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
		if (n == 1) {
			System.out.println("Di chuyển đĩa 1 từ cọc " + source + " tới cọc " + destination);
			return;
		}
		towerOfHanoi(n - 1, source, auxiliary, destination);
		System.out.println("Di chuyển đĩa " + n + " từ cọc " + source + " tới cọc " + destination);
		towerOfHanoi(n - 1, auxiliary, destination, source);
	}

	public static void main(String[] args) {
		int n = 3;
		towerOfHanoi(n, 'A', 'C', 'B');
	}
}
