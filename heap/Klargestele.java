package heap;

import java.util.PriorityQueue;

public class Klargestele {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[] = { 2 , 15, 8, 9, 12, 13, 20};
       int ans[] = klarge(arr,3);
       
       for(int i = 0 ; i < ans.length ; i++) {
    	   System.out.print(ans[i] + " ");
       }
	}
    public static int[] klarge(int arr[] , int  k ) {
    	int ans[] = new int[k];
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
         int i = 0 ;
    	for(; i < k ; i++) {
    	   pq.add(arr[i]);
       }
    	for(; i < arr.length ; i++) {
         int temp = pq.peek();
         if(temp < arr[i]) {
        	 pq.remove();
        	 pq.add(arr[i]);
         }
    	}
    	int l = 0 ;
    	while(!pq.isEmpty()) {
    		ans[l] = pq.remove();
    	     l++;
    	}
     
    	return ans ;
    }
}
