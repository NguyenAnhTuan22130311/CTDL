package task_02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> chuongSachList;

	public SachThamKhao(String title, int numberOfPages, int year, String author, double price, String linhVuc,
			List<ChuongSach> chuongSachList) {
		super(title, numberOfPages, year, author, price);
		this.linhVuc = linhVuc;
		this.chuongSachList = chuongSachList;
	}

	@Override
	public String getLoaiAnPham() {
		// TODO Auto-generated method stub
		return "Sách tham khảo";
	}

	public List<ChuongSach> getChuongSachList() {
		return chuongSachList;
	}

	public int soTrangChuongNhieuNhat() {
		int soTrangMax = Integer.MIN_VALUE;
		for (ChuongSach chuong : chuongSachList) {
			if (chuong.getNumberOfPages() > soTrangMax) {
				soTrangMax = chuong.getNumberOfPages();
			}
		}
		return soTrangMax;
	}

	@Override
	public String toString() {
		return "tieu de: " + title + " so trang: " + numberOfPages + " nam xuat ban: " + year + " tac gia: " + author
				+ " gia tien: " + price + " linh vuc: " + linhVuc + " chuong sach :" + chuongSachList + "\n";

	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice();
	}
}