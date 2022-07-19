package queues;

import java.util.*;

public class Slidingwindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 4, 3, 1, 2, 5, 3, 4, 7, 1, 9 };
		int a[] = slide(arr, 4);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static int[] slide(int arr[], int k) {
		Deque<Integer> a = new LinkedList<>();
		int ans[] = new int[arr.length - k + 1];
		int i = 0;
		for (i=0 ; i < k; i++) {
			while (!a.isEmpty() && arr[a.peekLast()] >= arr[i]) {
				a.removeLast();
			}

			a.addLast(i);
		}
		for (; i < arr.length; i++) {
			ans[i - k] = arr[a.peekFirst()];

			while (!a.isEmpty() && a.peekFirst() <= i - k) {
				a.removeFirst();
			}
			while (!a.isEmpty() && arr[a.peekLast()] >= arr[i]) {
				a.removeLast();
			}
			a.addLast(i);
		}
		ans[i - k] = arr[a.peekFirst()];

		return ans;

	}

}
