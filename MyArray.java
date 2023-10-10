package AlgorithmsProject;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearch(target, 0);
	}

	public int recursiveLinearSearch(int target, int index) {
		if (index >= array.length) {
			return -1;
		}
		if (array[index] == target) {
			return index;
		}

		return recursiveLinearSearch(target, index + 1);
	}

	public int iterativeBinarySearch(int target) {
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				return mid; // Tìm thấy vị trí
			} else if (array[mid] < target) {
				start = mid + 1; // Bỏ qua nửa trái
			} else {
				end = mid - 1; // Bỏ qua nửa phải
			}
		}
		return -1; // Không thấy giá trị
	}
	
	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearch(target, 0, array.length -1);
	}
	
	public int recursiveBinarySearch(int target, int start, int end) {
		if(start > end) {
			return -1;
		} 
		Arrays.sort(array);
		int mid = start + (end - start)/2;
		if(array[mid] == target) {
			return mid; //Tìm được vị trí
		} else if(array[mid] < target) {
			return recursiveBinarySearch(target, mid + 1, end); // Bỏ qua nửa trái
		} else {
			return recursiveBinarySearch(target, start, mid - 1); // Bỏ qua nửa phải
		}
	}
	public static void main(String[] args) {
		MyArray m1 = new MyArray(new int[] { 12, 10, 9, 45, 2, 10, 10, 45 });
		System.out.println(m1.iterativeLinearSearch(45));
		System.out.println(m1.recursiveLinearSearch(15));
		System.out.println(m1.iterativeBinarySearch(10));
		System.out.println(m1.recursiveBinarySearch(11));
	}
	}
