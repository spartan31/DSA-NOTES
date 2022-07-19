package queues;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingwinFirstNegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-8, 2, 3, -6, 10};
		int a[] = slide(arr,2);
		for(int i :a) {
			System.out.print(i + " ");
		}

	}

	public static int[] slide(int arr[], int k) {
		Deque<Integer> a = new LinkedList<>();
		int ans[] = new int[arr.length - k + 1];
		int i = 0;
		for (; i < k; i++) {
			if ( arr[i] < 0) {
				a.add(i);
			}
		}
		for (; i < arr.length; i++) {
			if(!a.isEmpty()) {
			ans[i - k] = arr[a.peekFirst()];
			} else {
				ans[i-k] = 0;
			}
			while (!a.isEmpty() && a.peekFirst() <= i - k) {
				a.removeFirst();
			}
			if (arr[i] < 0) {
				a.add(i);
			}

		}
		if(!a.isEmpty()) {
		ans[i-k] = arr[a.peekFirst()];
		} else {
			ans[i-k] = 0;
		}
		return ans;
	}
}