package task_02;

public class TapChi extends AnPham {
	private String tenTapChi;

	public TapChi(String title, int numberOfPages, int year, String author, double price, String tenTapChi) {
		super(title, numberOfPages, year, author, price);
		this.tenTapChi = tenTapChi;
	}

	public String getTenTapChi() {
		return tenTapChi;
	}

	@Override
	public String getLoaiAnPham() {
		// TODO Auto-generated method stub
		return "Tạp chí";
	}

	public boolean isTapChi() {
		if (this.getLoaiAnPham() == "Tạp chí" && (this.getYear() >= 2011 && this.getYear() <= 2021)) {
			return true;
		}
		return false;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice();
	}

	@Override
	public String toString() {
		return "tieu de: " + title + " so trang: " + numberOfPages + " nam xuat ban: " + year + " tac gia: " + author
				+ " gia tien: " + price + " ten tap chi: " + tenTapChi + "\n";
	}

	@Override
	public int soTrangChuongNhieuNhat() {
		// TODO Auto-generated method stub
		return 0;
	}

}