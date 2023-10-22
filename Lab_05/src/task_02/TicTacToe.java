package task_02;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private static final char X = 'X';
	private static final char O = 'O';
	public static char[][] board = new char[3][3];

	// Phương thức này kiểm tra tất cả các hàng và trả về true nếu bất kỳ hàng nào
	// được đánh dấu bởi
	// tất cả các dấu của một người chơi.
	// Nếu không, trả về false.
	public static boolean checkRow() {
		// Lặp qua từng hàng
		for (int row = 0; row < board.length; row++) {
			// Giả sử hàng hiện tại được đánh dấu bởi cùng 1 người chơi
			boolean samePlayer = true;
			// Lấy dấu đầu tiên trong hàng
			char maker = board[row][0];
			// Lặp qua từng cột trong hàng
			for (int col = 1; col < board[row].length; col++) {
				// Nếu vị trí hiện tại là trống hoặc khác với dấu đầu tiên
				if (board[row][col] == EMPTY || board[row][col] != maker) {
					// Đặt samePlayer thành false và thoát khỏi vòng lặp
					samePlayer = false;
					break;
				}
			}
			// Nếu samePlayer vẫn là true => Hàng hiện tại được đánh dấu bởi cùng 1 người
			// chơi
			if (samePlayer) {
				// Trả về true để chỉ ra chiến thắng
				return true;
			}
		}
		// Ngược lại
		return false;
	}

	// Phương thức này kiểm tra tất cả các cột và trả về true nếu bất kỳ cột nào
	// được đánh dấu bởi
	// tất cả các dấu của một người chơi.
	// Nếu không, trả về false.
	public static boolean checkColumns() {
		// lặp qua từng cột
		for (int col = 0; col < board[0].length; col++) {
			// Giả sử rằng cột hiện tại được đánh dấu bởi cùng 1 người chơi
			boolean samePlayer = true;
			// Lấy dấu đầu tiên trong cột
			char maker = board[0][col];
			// Lặp qua từng hàng trong cột
			for (int row = 1; row < board.length; row++) {
				// Nếu vị trí hiện tại trông hoặc khác với dấu đầu tiên
				if (board[row][col] == EMPTY || board[row][col] != maker) {
					// Đặt samePlayer thành false và thoát khỏi vòng lặp
					samePlayer = false;
					break;
				}
			}
			// Nếu samePlayer vẫn là true => cột hiện tại được đánh dấu bởi cùng 1 người
			// chơi
			if (samePlayer) {
				return true;
			}
		}
		// Ngược lại
		return false;
	}

	// Phương thức này kiểm tra cả hai đường chéo và trả về true nếu bất kỳ đường
	// chéo nào được đánh dấu bởi
	// tất cả các dấu của một người chơi. Nếu không, trả về false.
	public static boolean checkDiagonals() {
		// Giả sử rằng cả 2 đường chéo đều được đánh dấu bởi cùng 1 người chơi
		boolean samePlayer1 = true;
		boolean samePlayer2 = true;
		// Lấy dấu đầu tiên trong đường chéo từ trái xuống phải
		char maker1 = board[0][0];
		// Lấy dấu đầu tiên trong đường chéo từ dưới trái lên phải
		char maker2 = board[board.length - 1][0];
		// Lặp qua từng vị trí trong cả 2 đường chéo
		for (int i = 1; i < board.length; i++) {
			// Nếu vị trí hiện tại trong đường chéo từ trên trái xuống phải là trống hoặc
			// khác với dấu đầu tiên
			if (board[i][i] == EMPTY || board[i][i] != maker1) {
				// Đặt samePlayer1 thành false
				samePlayer1 = false;
			}
			// Nếu vị trí hiện tại trong đường chéo từ dưới trái lên phải là trống hoặc khác
			// với dấu đầu tiên
			if (board[board.length - 1][i] == EMPTY || board[board.length - 1][i] != maker2) {
				// Đặt samePlayer thành false
				samePlayer2 = false;
			}
		}

		// Nếu cả samePlayer1 và samePlayer2 là true => Một trong hai đường chéo được
		// đánh dấu bởi cùng một người chơi
		if (samePlayer1 || samePlayer2) {
			// Trả về true để chỉ chiến thắng
			return true;
		}
		// Ngược lại
		return false;
	}

	public static void main(String[] args) {
		// Khởi tạo bàn cờ bằng các ô trống
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = EMPTY;
			}
		}

		board[0][0] = X;
		board[0][1] = X;
		board[0][2] = X;
		board[1][0] = O;
		board[1][1] = X;
		board[1][2] = O;
		board[2][0] = O;
		board[2][1] = X;
		board[2][2] = EMPTY;

		// In ra bảng cờ hiện tại
		System.out.println("Bảng cờ hiện tại:");
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
		if (checkRow() || checkColumns() || checkDiagonals()) {
			System.out.println("Người chơi " + board[1][1] + " đã chiến thắng!");
		} else {
			System.out.println("Hòa nhau!");
		}
	}

}
