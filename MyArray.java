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

	public int[] getMissingValues() {
		// Tìm giá trị lớn =, nhỏ nhất
		int min = array[0];
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min)
				min = array[i];
			if (array[i] > max)
				max = array[i];
		}

		int[] missingValues = new int[max - min + 1 - array.length];
		int index = 0;

		for (int i = min; i <= max; i++) {
			boolean found = false;
			for (int j = 0; j < array.length; j++) {
				if (array[j] == i) {
					found = true;
					break;
				}
			}
			if (!found) {
				missingValues[index++] = i;
			}
		}
		return missingValues;
	}

	public int[] fillMissingValues(int k) {
		int n = array.length;

		for (int i = 0; i < n - 1; i++) {
			if (array[0] == -1) {
				array[0] = (array[i + 1] + array[i + 2] + array[i + 3]) / k;
			}
			if (array[n - 1] == -1) {
				array[n - 1] = (array[n - 1] + array[n - 2] + array[n - 3]) / k;
			} else if (array[i] == -1) {
				if (array[i - 1] + array[i - 2] + array[i + 1] > array[i + 1] + array[i + 2] + array[i - 1]) {
					array[i] = (array[i + 1] + array[i + 2] + array[i - 1]) / k;
				} else {
					array[i] = (array[i - 1] + array[i - 2] + array[i + 1]) / k;
				}

			}
		}

		return array;
	}

	public static void main(String[] args) {
		MyArray myArray1 = new MyArray(new int[] { 1, 2, 3 });
		MyArray myArray2 = new MyArray(new int[] { 1, 3, 5, 1, 3, 7, 9, 8 });
		MyArray myArray3 = new MyArray(new int[] { 10, 11, 12, 13, 14, 16, 17, 19, 20 });
		MyArray myArray4 = new MyArray(new int[] { 10, 11, 12, -1, 14, 10, 17, 19, 20 });
		int[] mirrorArray = myArray1.mirror();
		int[] removeDuplicates = myArray2.removeDuplicates();
		int[] getMissingValues = myArray3.getMissingValues();
		int[] fillMissingValues = myArray4.fillMissingValues(3);
		System.out.println(Arrays.toString(mirrorArray));
		System.out.println(Arrays.toString(removeDuplicates));
		System.out.println(Arrays.toString(getMissingValues));
		System.out.println(Arrays.toString(fillMissingValues));
	}
}
