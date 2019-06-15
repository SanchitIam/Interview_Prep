package snq;

import java.util.*;

class AbsolutePath {
	public static String absoluteCanonicalPath(String s) {
		Stack<String> stk = new Stack<>();

		for (int i = 0; i < s.length(); ++i) {
			String dir = "";

			while (i < s.length() && s.charAt(i) == '/') {
				i++;
			}

			while (i < s.length() && s.charAt(i) != '/') {
				dir += s.charAt(i);
				i++;
			}

			if (dir.equals("..")) {
				if (stk.size() > 0)
					stk.pop();

			} else if (dir.equals(".")) {

				continue;
			} else if (dir.length() != 0) {

				stk.push(dir);
			}
		}

		String res = "/";

		Stack<String> st1 = new Stack<String>();
		while (!stk.empty()) {

			st1.push(stk.pop());
			// st.pop();
		}

		// the st1 will contain the actual res.
		while (!st1.empty()) {

			// if it's the last element no need
			// to append "/"
			if (st1.size() != 1)
				res += (st1.pop() + "/");
			else
				res += st1.pop();

			// st1.pop();
		}
		return res;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = sc.next();
		System.out.print(absoluteCanonicalPath(path));
	}
}