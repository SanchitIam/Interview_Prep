package cc;

import java.util.TreeMap;

public class all_possible_palindrome {
	static int CountPS(String str, int n) {
		// creat empty 2-D matrix that counts all palindrome
		// substring. dp[i][j] stores counts of palindromic
		// substrings in st[i..j]
		int dp[][] = new int[n][n];

		// P[i][j] = true if substring str[i..j] is palindrome,
		// else false
		boolean P[][] = new boolean[n][n];

		// palindrome of single lenght
		for (int i = 0; i < n; i++)
			P[i][i] = true;

		// palindrome of length 2
		for (int i = 0; i < n - 1; i++) {
			if (str.charAt(i)== str.charAt(i + 1)) {
				P[i][i + 1] = true;
				dp[i][i + 1] = 1;
			}
		}

		// Palindromes of length more then 2. This loop is similar
		// to Matrix Chain Multiplication. We start with a gap of
		// length 2 and fill DP table in a way that gap between
		// starting and ending indexes increases one by one by
		// outer loop.
		for (int gap = 2; gap < n; gap++) {
			// Pick starting point for current gap
			for (int i = 0; i < n - gap; i++) {
				// Set ending point
				int j = gap + i;

				// If current string is palindrome
				if (str.charAt(i) == str.charAt(j) && P[i + 1][j - 1])
					P[i][j] = true;

				// Add current palindrome substring ( + 1)
				// and rest palinrome substring (dp[i][j-1] + dp[i+1][j])
				// remove common palinrome substrings (- dp[i+1][j-1])
				if (P[i][j] == true)
					dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1 - dp[i + 1][j - 1];
				else
					dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
			}
		}

		// return total palindromic substrings
		return dp[0][n - 1]+n;
	}

	public static void main(String[] args) {
		System.out.println(CountPS("ababa", 5));
	}

}