package stack;

import java.util.*;

public class Nextgreaterelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = { 2,1,3,8,6,7,5};
		
		Stack<Integer> a = new Stack<>();
		for(int i = 0 ; i < arr.length ; i++) {
			while(!a.isEmpty() && arr[i] > a.peek()) {
				int rv = a.pop();
				System.out.println(rv + " ->  " +  arr[i]);
			}
			a.push(arr[i]);
		}
		while(!a.isEmpty()) {
			int rv = a.pop();
			System.out.println(rv + " -> " +  "-1 ");
		}

	}

}
