package sortingAlgorithms;

public class Task_02 {
	public static void mergeSort(int[] array, int left, int right) {
		// Check mảng nếu như có nhiều hơn 1 phần tử
		if (left < right) {
			// Tìm vị trí trung tâm của mảng
			int middle = (left + right) / 2;
			// Sắp xếp nửa bên trái của mảng
			mergeSort(array, left, middle);
			// Sắp xếp nửa bên phải của mảng
			mergeSort(array, middle + 1, right);
			// Hợp nhất hai nửa
			merge(array, left, middle, right);
		}
	}

	// Xác định hàm hợp nhất 2 mảng con được sắp xếp
	public static void merge(int[] array, int left, int half, int right) {
		// Tìm kích thước mảng con
		int n1 = half - left + 1;
		int n2 = right - half;
		// Tạo mảng tạm thời để lưu trữ các mảng con
		int[] first = new int[n1];
		int[] last = new int[n2];
		// Sao chép dữ liệu mảng ban đầu vào mảng con
		for (int i = 0; i < n1; i++) {
			first[i] = array[left + i];
		}
		for (int j = 0; j < n2; j++) {
			last[j] = array[half + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = left;
		// Hợp nhât các mảng con bằng cách so sánh các phần tử của chúng
		while (i < n1 && j < n2) {
			if (first[i] <= last[j]) {
				array[k] = first[i];
				i++;
			} else {
				array[k] = last[j];
				j++;
			}
			k++;
		}
		// Sao chép các phần tử còn lại của mảng con bên trái (nếu có)
		while (i < n1) {
			array[k] = first[i];
			i++;
			k++;
		}
		// Sao chép các phần tử còn lại của mảng con bên phải (nếu có)
		while (j < n2) {
			array[k] = last[j];
			j++;
			k++;
		}
	}

	// In ra mảng đã sắp xếp
	public static void printArray(int[] array) {
		for (int element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);
			quickSort(array, low, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = getPivot_MedianOfThree(array, low, high);
		swap(array, pivot, high);
		pivot = high;
		int i = low - 1;
		int j = low;
		while (j < high) {
			if (array[j] <= array[pivot]) {
				i++;
				swap(array, i, j);
			}
			j++;
		}
		swap(array, i + 1, pivot);
		return i + 1;
	}

	private static int getPivot_MedianOfThree(int[] array, int low, int high) {
		int mid = low + (high - low) / 2;
		if (array[low] > array[mid]) {
			swap(array, low, mid);
		}
		if (array[low] > array[high]) {
			swap(array, low, high);
		}
		if (array[mid] > array[high]) {
			swap(array, mid, high);
		}
		return mid;
	}

	private static int getPivot_First(int[] array) {
		return 0;
	}

	private static int getPivot_Last(int[] array) {
		return array.length - 1;
	}

	private static int getPivot_Random(int[] array) {
		int randomIndex = (int) (Math.random() * array.length);
		return randomIndex;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		// Test MergeSort
		int[] arr = { 6, 5, 12, 10, -9, 1 };
		System.out.println("Original array:");
		printArray(arr);
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("MergeSorted array:");
		printArray(arr);
		
		// Test QuickSort
		// tạo một mảng ngẫu nhiên gồm 10 phần tử
		int[] array = new int[6];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		// in mảng trước khi sắp xếp
		System.out.println("Original array:");
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
		// gọi hàm quickSort để sắp xếp mảng
		quickSort(array);
		// in mảng sau khi sắp xếp
		System.out.println("QuickSorted array:");
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
