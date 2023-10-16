package Task_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Order {
	private OderItem[] items;

	public Order(OderItem[] items) {
		super();
		this.items = items;
	}

	public OderItem[] getItems() {
		return items;
	}

	public double cost() {
		double totalCost = 0.0;

		// Duyệt qua mảng các sản phẩm trong đơn hàng
		for (OderItem item : items) {
			Product product = item.getP(); // Lấy thông tin sp
			int quantity = item.getQuality(); // Lấy số lượng sp

			// Tính tổng giá tiền của từng sản phẩm và cộng vào tổng giá tiền của đơn hàng
			totalCost += product.getPrice() * quantity;
		}

		return totalCost;
	}

	public boolean contains(Product p) {
		int left = 0;
		int right = items.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			Product currentProduct = items[mid].getProduct();

			// So sánh sản phẩm ở giữa với sản phẩm cần tìm
			int comparisonResult = currentProduct.compareTo(p);

			if (comparisonResult == 0) {
				// Sản phẩm được tìm thấy
				return true;
			} else if (comparisonResult < 0) {
				// Sản phẩm cần tìm nằm bên phải sản phẩm ở giữa
				left = mid + 1;
			} else {
				// Sản phẩm cần tìm nằm bên trái sản phẩm ở giữa
				right = mid - 1;
			}
		}

		// Sản phẩm không được tìm thấy
		return false;
	}

	public void sortByPrice() {
	  for (int i = 0; i < items.length - 1; i++) {
	    boolean swapped = false;
	    for (int j = 0; j < items.length - i - 1; j++) {
	      if (items[j].getProduct().getPrice() < items[j + 1].getProduct().getPrice()) {
	        OderItem temp = items[j];
	        items[j] = items[j + 1];
	        items[j + 1] = temp;
	        swapped = true;
	      }
	    }
	    if (!swapped) {
	      break;
	    }
	  }
	}

	public Product[] filter(String type) {
		List<Product> product = new ArrayList<>();
		for (OderItem item : items) {
			Product pr = item.getProduct();
			if (pr.getType().equals(type)) {
				product.add(pr);
			}
		}
		return product.toArray(new Product[0]);
	}

	@Override
	public String toString() {

		return "items" + items;
	}
}
