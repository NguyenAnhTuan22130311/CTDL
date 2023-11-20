package task_02;

import java.util.List;

public abstract class AnPham implements Comparable<AnPham> {
	protected String title;
	protected int numberOfPages;
	protected int year;
	protected String author;
	protected double price;

	public AnPham(String title, int numberOfPages, int year, String author, double price) {
		super();
		this.title = title;
		this.numberOfPages = numberOfPages;
		this.year = year;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public int getYear() {
		return year;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public abstract String getLoaiAnPham();

	// Kiểm tra hai ấn phẩm cùng loại và cùng tác giả hay không
	public boolean cungLoaiVaTacGia(AnPham anPhamKhac) {
		return this.getLoaiAnPham().equals(anPhamKhac.getLoaiAnPham()) && this.author.equals(anPhamKhac.author);
	}

	@Override
	public int compareTo(AnPham anPham) {
		// Tăng dần theo tiêu đề
		int result = this.title.compareTo(anPham.title);

		// If tiêu đề giống nhau, giảm dần theo năm xuất bản
		if (result == 0) {
			result = Integer.compare(anPham.year, this.year);
		}

		return result;
	}

	@Override
	public String toString() {
		return "tieu de: " + title + " so trang: " + numberOfPages + " nam xuat ban: " + year + " tac gia: " + author
				+ " gia tien: " + price + "\n";
	}

	public abstract int soTrangChuongNhieuNhat();

}