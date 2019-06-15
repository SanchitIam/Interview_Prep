package snq;

import java.util.*;

class CircularDequeue {

	static class CircularDeque {

		public LinkedList<Integer> cdeque;
		public int size;

		public CircularDeque(int k) {
			size = k;
			cdeque = new LinkedList<>();
		}

		public boolean insertFront(int value) {
			if(cdeque.size()!=size) {
				cdeque.addFirst(value);
				return true;
			}
			
			return false;
		}

		public boolean insertLast(int value) {
			if(cdeque.size()!=size) {
				cdeque.addLast(value);
				return true;
			}
			
			return false;
		}

		public boolean deleteFront() {
			
			return cdeque.removeFirst()!=null;
		}

		public boolean deleteLast() {
			return cdeque.removeLast()!=null;
		}

		public int getFront() {
			return cdeque.getFirst();
		}

		public int getRear() {
			return cdeque.getLast();
		}

		public boolean isEmpty() {
			return cdeque.isEmpty();
		}

		public boolean isFull() {
			return size == cdeque.size();
		}

	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircularDeque cd = new CircularDeque(sc.nextInt());
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int q = sc.nextInt();
			String s = "";
			if (q == 1) {
				s = "" + cd.insertFront(sc.nextInt());
			} else if (q == 0) {
				s = "" + cd.insertLast(sc.nextInt());
			} else if (q == 2) {
				s = "" + cd.deleteFront();
			} else if (q == -2) {
				s = "" + cd.deleteLast();
			} else if (q == 3) {
				s = "" + cd.getFront();
			} else if (q == -3) {
				s = "" + cd.getRear();
			} else if (q == 4) {
				s = "" + cd.isEmpty();
			} else if (q == 5) {
				s = "" + cd.isFull();
			}
			System.out.print(s + " ");
		}

	}

}