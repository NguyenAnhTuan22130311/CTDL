package arrayProject;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int[] mirror() {
		int[] mirrorArray = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			mirrorArray[i] = array[i];
			mirrorArray[mirrorArray.length - 1 - i] = array[i];
		}
		return mirrorArray;
	}

	public int[] removeDuplicates() {
		// Sắp xếp mảng theo thứ tự tăng dần
		Arrays.sort(array);

		int[] temp = new int[array.length];
		int j = 0;

		// Duyệt mảng
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] != array[i + 1]) {
				temp[j++] = array[i];
			}
		}
		temp[j++] = array[array.length - 1];
		return Arrays.copyOf(temp, j);
	}

	public static void main(String[] args) {
		MyArray myArray1 = new MyArray(new int[] { 1, 2, 3 });
		MyArray myArray2 = new MyArray(new int[] { 1, 3, 5, 1, 3, 7, 9, 8 });
		int[] mirrorArray = myArray1.mirror();
		int[] removeDuplicates = myArray2.removeDuplicates();
		System.out.println(Arrays.toString(mirrorArray));
		System.out.print(Arrays.toString(removeDuplicates));
	}
}
