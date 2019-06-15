package snq;

import java.util.*;
import java.lang.*;
import java.io.*;

class RemoveRepeatedDigits {

	static long removeRep(long n) {
		Stack<Long> stk = new Stack<>();
		long nc = n;

		while (nc != 0) {
			long digit = nc % 10;
			nc = nc / 10;
			while (stk.size() > 0 && stk.peek() == digit) {
				stk.pop();
			}

			stk.push(digit);
		}

		long rv = 0;
		while (stk.size() > 0) {
			rv = (rv * 10) + stk.pop();
		}

		return rv;

	}

	// Dont make changes here
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		System.out.println(removeRep(A));

	}

}