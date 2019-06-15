package snq;

public class IntegerInString {

	public static void main(String[] args) {
		int size = 0;
		int j = 0;
		String S="adfsdfhg";
		for (int i = 0; i < S.length(); ++i, j++) {
			char ch = S.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				size++;
			} else {
				String s = "";
				char c = S.charAt(j);
				while (c >= '0' && c <= '9') {
					s = s + c + "";
					j++;
					c = S.charAt(j);
				}
				j--;
				i = j;
				int val = Integer.parseInt(s);
				size = size * val;
			}
		}
		System.out.println(size);


	}

}
