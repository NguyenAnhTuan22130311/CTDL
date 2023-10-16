package sortingAlgorithms;

import java.util.Arrays;

public class Task_01 {
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[maxIndex]) {
					maxIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[maxIndex];
			array[maxIndex] = temp;
		}
		System.out.println(Arrays.toString(array));
	}

	public static void bubbleSort(int[] array) {
		for (int i = 1; i < array.length - 1; i++) {
			boolean swaped = false;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swaped = true;
				}
			}
			if (!swaped) {
				break;
			}
		}
		System.out.println(Arrays.toString(array));
	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j >= 0 && array[i] < array[j]) {
				int temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
				j--;
			}
		}
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, -1, 9 };
		selectionSort(arr);
		bubbleSort(arr);
		insertionSort(arr);
	}
}
