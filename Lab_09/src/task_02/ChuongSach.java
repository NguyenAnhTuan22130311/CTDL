package task_02;

public class ChuongSach {
	private String title;
	private int numberOfPages;

	public ChuongSach(String title, int numberOfPages) {
		super();
		this.title = title;
		this.numberOfPages = numberOfPages;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	@Override
	public String toString() {
		return "tieu de: " + title + " so trang: " + numberOfPages + "\n";
	}

}