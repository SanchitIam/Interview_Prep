package snq;

import java.util.*;

public class FunctionTime {

	static class Helper {
		int p;
		int st;
		int nmt;
		char ch;

		Helper(int p, int st, int nmt, char ch) {
			this.p = p;
			this.st = st;
			this.nmt = nmt;
			this.ch = ch;
		}
	}

	public static int[] exclusiveTime(int n, List<String> logs) {

		for (int i = 0; i < logs.size(); ++i) {
			String s = logs.get(i);

			// make node
			Helper h = makenode(s);

			// stack

		}
	}

	private static Helper makenode(String s) {
		int i = 0;
		char ch = '0';
		String fid = "";
		while (i < s.length() && Character.isDigit(ch)) {
			ch = s.charAt(i);
			fid = fid + ch;
			i++;
		}
		i++;
		char se = 
		while (i < s.length() && !Character.isDigit(ch)) {
			++i;
		}

		Helper h = new Helper(Integer.parseInt(fid), st, 0,);
		return null;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int L = sc.nextInt();
		List<String> logs = new ArrayList<>(L);
		for (int i = 0; i < L; i++) {
			logs.add(sc.next());
		}
		int[] res = exclusiveTime(n, logs);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}