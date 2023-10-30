package task_01;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// Tạo 1 mảng có kích thước gấp đôi nếu các phần tử của mảng đã đầy
	public void growSize() {
		if (size == elements.length) {
			// Tạo 1 mảng mới có kích thước gấp đôi so với kích thước hiện tại
			E[] newElements = (E[]) new Object[elements.length * 2];
			// Sao chép các phần tử hiện tại sang mảng mới
			newElements = Arrays.copyOf(elements, elements.length);
			// Gán mảng mới cho trường elements
			elements = newElements;
		}
	}

	// Trả về số lượng phần tử trong danh sách này
	public int size() {
		return size;
	}

	// Trả về true nếu danh sách rỗng
	public boolean isEmpty() {
		return size == 0;
	}

	// Trả về (nhưng không xóa) phần tử tại chỉ số i
	public E get(int i) throws IndexOutOfBoundsException {
		// Kiểm tra tính họp lệ của chỉ số
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + size);
		}
		// Trả về phần tử tại chỉ số đã cho
		return elements[i];
	}

	// Thay thế các phần tử tại chỉ số i = e và trả về phần tử đã đc thay thế
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// Kiểm tra tính hợp lệ của chỉ số
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + size);
		}
		// Lấy phần tử hiện tại tại chỉ số đã cho
		E oldElement = elements[i];
		// Thay thế nó bằng phần tử mới
		elements[i] = e;
		// Trả về phần tử cũ
		return oldElement;
	}

	// Đc sử dụng để thêm phần tử đã chỉ định vào cuối danh sách
	public boolean add(E e) {
		// Kiểm tra xem mảng có đầy hay không
		if (size == elements.length) {
			// Tăng kích thước của mảng
			growSize();
		}
		// Thêm phần tử vào cuối mảng
		elements[size] = e;
		size++;
		// Trả về true nếu thành công
		return true;
	}

	// Chèn phần tử e vào vị trí i, dịch chuyển tất cả các phần tử tiếp theo sang
	// bên phải
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i > size || i < 0) {
			throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + size);
		} else if (i == elements.length) {
			growSize();
		}
		// Dịch chuyển các phần tử i sang bên phải 1 vị trí
		for (int j = size - 1; j >= i; j--) {
			elements[j + 1] = elements[j];
		}
		// Chèn phần tử vào vị trí i
		elements[i] = e;
		// Tăng kích thước
		size++;
	}

	// Xóa và trả về phần tử tại chỉ số i, dịch chuyển các phần tử tiếp theo sang
	// bên trái
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + size);
		}
		E removeElement = elements[i];
		// Dịch chuyển các phần tử sang bên trái 1 vị trí
		for (int j = i + 1; j < size; j++) {
			elements[j - 1] = elements[j];
		}
		// giảm kích thước
		size--;
		// Trả về phần tử đã xóa
		return removeElement;
	}

	// Đc sử dụng để xóa toàn bộ phần tử trong mảng
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	// Được sử dụng để trả về chỉ số trong danh sách này của
	// lần xuất hiện cuối cùng của phần tử đã chỉ định, hoặc -1 nếu
	// danh sách không chứa phần tử này.
	public int lastIndexOf(Object o) {
		// Lặp từ phải sang trái
		for (int i = size - 1; i >= 0; i--) {
			// Kiểm tra xem phần tử có bằng đối tượng đã cho 0
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	// Được sử dụng để trả về một mảng chứa tất cả các
	// phần tử trong danh sách này theo thứ tự chính xác.
	public E[] toArray() {
		// tạo một mảng mới có cùng loại và kích thước với danh sách
		E[] array = (E[]) new Object[size];
		// sao chép các phần tử từ danh sách sang mảng
		for (int i = 0; i < size; i++) {
			array[i] = elements[i];
		}
		// trả về mảng
		return array;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> copy = new MyArrayList<E>(elements.length);

		return copy;
	}

	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return true;
			}
		}
		return false;

	}

	// It is used to return the index in this list of the first occurrence of the
	// specified element, or -1 if the List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o))
				return i;
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.
	public boolean remove(E e) {
		int index = indexOf(e);
		int check = 0;
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(e))
				check++;
			if (elements[i].equals(e) || i == index) {
				break;
			}
		}
		return (check == 1);
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.
	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}

	public static void main(String[] args) {
		MyArrayList<Integer> myArray = new MyArrayList<>();
		myArray.add(45);
		myArray.add(30);
		myArray.add(3);
		myArray.add(-3);
		myArray.remove(1);
		// myArray.clear();
		for (int i = 0; i < myArray.size(); i++) {
			System.out.print(myArray.get(i) + " ");
		}
		System.out.println(" ");
		System.out.println("Last index of 3: " + myArray.lastIndexOf(3));
		// System.out.println(myArray.remoVe(2));
		// System.out.println(myArray.indexOf(33));
		// System.out.println(myArray.remove(33));
		// System.out.println(myArray.get(3));
		// System.out.println(myArray.size);
	}
}
