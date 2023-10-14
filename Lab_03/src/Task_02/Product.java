package Task_02;

public class Product {
	private String id;
	private String name;
	private double price;
	private String type;
	
	public Product(String id, String name, double price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "id: " + id + "name:" + name + "price:" + price + ", type=" + type + ",";
	}

	public Object getType() {
		return type;
	}

	public int compareTo(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
