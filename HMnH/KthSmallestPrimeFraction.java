package HMnH;

import java.util.*;

public class KthSmallestPrimeFraction {

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input the head of the linked list.
	// It should return the head of the modified list.

	public static class Helper {
		int i;
		int j;
		Double frac;

		Helper(int i, int j, double frac) {
			this.i = i;
			this.j = j;
			this.frac = frac;
		}

	}

	public static int[] kthSmallestPrimeFraction(int[] A, int K) {
		int[] rv = new int[2];

		Arrays.sort(A);
		for (int i = 0; i < A.length; ++i) {
			System.out.print(A[i] + "	");
		}
		Comparator<Helper> cmp = new Comparator<Helper>() {

			@Override
			public int compare(Helper o1, Helper o2) {
				// TODO Auto-generated method stub
				return o1.frac.compareTo(o2.frac);
			}

		};
		PriorityQueue<Helper> q = new PriorityQueue<Helper>(cmp);
		for (int i = 0; i < A.length - 1; ++i) {
			Helper h = new Helper(i, A.length - 1, (A[i] * 1.0) / A[A.length - 1]);

			q.add(h);
		}

		// while (q.size() > 0) {
		// Helper p = q.remove();
		// System.out.println(A[p.i] + "/" + A[p.j] + " " + p.frac);
		//
		// }
		Helper rm = null;
		for (int i = 0; i < K; ++i) {
			rm = q.remove();
			// System.out.println(A[rm.i] + "/" + A[rm.j]);
			if (rm.i >= rm.j - 1) {
				continue;
			} else {
				q.add(new Helper(rm.i, rm.j - 1, (A[rm.i] * 1.0) / A[rm.j - 1]));
			}
		}

		rv[0] = A[rm.i];
		rv[1] = A[rm.j];

		return rv;

	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] ans = kthSmallestPrimeFraction(arr, k);

		System.out.println(ans[0] + "/" + ans[1]);

	}

}