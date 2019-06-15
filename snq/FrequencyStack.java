package snq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class FrequencyStack {

	private static class FreqStack {

		static HashMap<Integer, Integer> fmap;
		static HashMap<Integer, Stack<Integer>> smap;
		static int mf;

		// Write your code
		public FreqStack() {
			fmap = new HashMap<>();
			smap = new HashMap<>();
			mf = 0;
		}

		public static void push(int x) {
			if (fmap.containsKey(x)) {
				if (mf < fmap.get(x) + 1) {
					mf++;
				}
				fmap.put(x, fmap.get(x) + 1);
			} else {
				fmap.put(x, 1);
			}

			if (smap.containsKey(fmap.get(x))) {
				Stack<Integer> st = smap.get(fmap.get(x));
				st.push(x);
				smap.put(fmap.get(x), st);
			} else {
				Stack<Integer> st = new Stack<>();
				st.push(x);
				smap.put(fmap.get(x), st);
			}

		}

		public static int pop() {
			int rv = smap.get(mf).pop();
			if (smap.get(mf).size() == 0) {
				mf--;
			}

			fmap.put(rv, fmap.get(rv) - 1);
			return rv;
		}
	}

	// Dont make changes here
	public static void main(String[] args) {
		FreqStack fq = new FreqStack();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		while (i != n) {
			int q = sc.nextInt();
			if (q == 1) {
				i++;
				fq.push(sc.nextInt());
			} else if (q == 2)
				System.out.println(fq.pop());
			i++;
		}
	}

}
