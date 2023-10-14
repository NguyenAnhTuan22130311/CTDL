package Task_02;

public class TestOrder {
	public static void main(String[] args) {
		Product p1 = new Product("001", "Coca cola", 10.0, "Soft Drink");
		Product p2 = new Product("003", "Chips", 12.0, "Snack");
		Product p3 = new Product("004", "Graham Cookie", 7.0, "Cookie");
		Product p4 = new Product("002", "Pepsi", 8.0, "Soft Drink");

		OderItem it1 = new OderItem(p1, 2);
		OderItem it2 = new OderItem(p2, 2);
		OderItem it3 = new OderItem(p3, 2);
		OderItem it4 = new OderItem(p4, 2);

		OderItem it[] = { it1, it2, it3, it4 };
		Order order = new Order(it);

		// method cost()
		double cost = order.cost();
		System.out.println("Cost: " + cost);

		// method sort()
		System.out.println();
		System.out.println("trước khi sắp xếp");
		OderItem[] sortedItems1 = order.getItems();
		for (OderItem pr : sortedItems1) {
			System.out.println(pr.getProduct().getPrice());
		}
		System.out.println("Sau khi sắp xếp");
		order.sortByPrice();

		OderItem[] sortedItems = order.getItems();
		for (OderItem item : sortedItems) {
			System.out.println(item.getProduct().getPrice());

		}

		System.out.println();
		// method contains()
		System.out.println("Contain: ");
		boolean check = order.contains(p1);
		System.out.println(check);

		// method filter()
		System.out.println();
		String typeToFilter = "Soft Drink";
		Product[] filteredProducts = order.filter(typeToFilter);
		for (Product pr : filteredProducts) {
			System.out.println(pr);
		}
	}
}