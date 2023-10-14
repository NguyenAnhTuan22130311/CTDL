package Task_02;

public class OderItem {
	private Product p;
	private int quality;
	public OderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}
	public Product getP() {
		return p;
	}
	public int getQuality() {
		return quality;
	}
	@Override
	public String toString() {
		return "p:" + p + "quality:" + quality + ",";
	}
	
	public Product getProduct() {
		return p;
	}
}
