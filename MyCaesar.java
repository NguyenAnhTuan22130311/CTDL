package arrayProject;

public class MyCaesar {
	public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,:;!?@#$%&*()-_=+[]{}<>/\\\"'";
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Mã hóa một ký tự theo số bước dịch chuyển cho trước
	public char encryptChar(char c) {
		if (ALPHABET.contains(String.valueOf(c))) {
			// Tìm chỉ số c trong chuỗi ALPHABET
			int index = ALPHABET.indexOf(c);
			// Cộng số bước dịch chuyển vào chỉ số và quay lại đầu chuỗi nếu cần
			int newIndex = (index + n) % ALPHABET.length();
			// Trả về ký tự ở chỉ số mới
			return ALPHABET.charAt(newIndex);
		} else {
			// Không phải ký tự trong chuỗi
			return c;
		}
	}

	// Mã hóa một văn bản theo số bước dịch chuyển cho trước
	public String encryptText(String text) {
		// Tạo StringBuilder để lưu trữ văn bản đã mã hóa
		StringBuilder sb = new StringBuilder();
		// Lặp ký tự
		for (char c : text.toCharArray()) {
			// Mã hóa từng ký tự và thêm nó vào StringBuilder
			sb.append(encryptChar(c));
		}
		return sb.toString();
	}

	// Giải mã một ký tự theo số bước dịch chuyển cho trước
	public char decryptChar(char c) {
		if (ALPHABET.contains(String.valueOf(c))) {
			int index = ALPHABET.indexOf(c);
			// Trừ số bước dịch chuyển ra khỏi chỉ số và quay lại cuối chuỗi nếu cần
			int newIndex = (index - n + ALPHABET.length()) % ALPHABET.length();
			return ALPHABET.charAt(newIndex);
		} else {
			return c;
		}
	}

	// Giải mã một văn bản theo số bước dịch chuyển cho trước
	public String decryptText(String text) {
		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {

			sb.append(decryptChar(c));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MyCaesar cipher = new MyCaesar(3);
		System.out.println(cipher.encryptChar('T'));
		System.out.println(cipher.decryptChar('D'));
		System.out.println(cipher.encryptText("HELLO JAVA"));
		System.out.println(cipher.decryptText("PB QDPH LV WXDQ"));
		System.out.println(cipher.encryptText("DH22DTC"));
		System.out.println(cipher.decryptText("PB QDPH LV WXDQ !@#$"));
	}

}
