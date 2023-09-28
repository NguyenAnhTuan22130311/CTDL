package arrayProject;

public class MyCaesar {
	public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,:;!?@#$%&*()-_=+[]{}<>/\\\"'";
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	public char encryptChar(char c) {
		if (ALPHABET.contains(String.valueOf(c))) {
			int index = ALPHABET.indexOf(c);
			int newIndex = (index + n) % ALPHABET.length();
			return ALPHABET.charAt(newIndex);
		} else {
			return c;
		}
	}

	public String encryptText(String text) {
		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			sb.append(encryptChar(c));
		}
		return sb.toString();
	}

	public char decryptChar(char c) {
		if (ALPHABET.contains(String.valueOf(c))) {
			int index = ALPHABET.indexOf(c);
			int newIndex = (index - n + ALPHABET.length()) % ALPHABET.length();
			return ALPHABET.charAt(newIndex);
		} else {
			return c;
		}
	}

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
