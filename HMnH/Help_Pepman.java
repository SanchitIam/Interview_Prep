package HMnH;

import java.util.*;

public class Help_Pepman {

	public static void helpPepman(String S) {
		int x = 0, y = 0;
		for (int i = 0; i < S.length(); ++i) {
			char ch = S.charAt(i);
			if ((i + 1) % 2 == 0 && (ch - 'a' + 1) % 2 == 0) {
				x++;
			} else if ((i + 1) % 2 == 1 && (ch - 'a' + 1) % 2 == 1) {
				y++;
			}
		}
		int sum = x + y;
		if (sum % 2 == 0) {
			System.out.println("EVEN");
		} else {
			System.out.println("ODD");
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		helpPepman(s);
	}

}
