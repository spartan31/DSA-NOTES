package dp;

import java.util.*;

class longestincreasingsubsarr {

	public static void main(String[] args) {
		
		
		int arr[] = {1, 4, 2, 5, 6, 4, 6, 4,8, 5,7 } ;
		int a[] = {3, 4, -1, 0, 6, 2, 3} ;
		System.out.println(lisbu(a));
		
		System.out.println(lis(a));
	}
	
	/// n2 complexity
     public static int lisbu(int[] arr) {
    	 int sto[] = new int[arr.length] ;
    	 int mxa = 1 ;
    	 Arrays.fill(sto, 1);
    	 for(int i = 0 ; i < sto.length ; i++) {
    		 for(int j = 0 ; j < i ; j++ ) {
    			 if(arr[i] > arr[j]) {
    				 sto[i] = Math.max(sto[i],sto[j]+1) ;
    				 mxa = Math.max(mxa, sto[i]) ;
    			 }
    		 }
    	 }
    	 return mxa ;
     }
     
     
     
     //nlogn complexity
     
     public static int lis(int arr[]) {
    	 int le[] = new int[arr.length] ;
    	 le[0] = arr[0];
    	 int len = 1 ;
    	 for(int i = 0 ; i < arr.length ; i++) {
    		 if(arr[i] > le[len -1]) {
    			 le[len] = arr[i] ;
    			 len++ ;
    		 }else {
    			 int idx = binary(le,0,len-1,arr[i]);
    		   le[idx] = arr[i] ;
    		 } 
    	 }
    	 return len ;
     }

	private static int binary(int[] le, int si ,int ei, int item) {
		int low = si ;
		int high = ei ;
		
		while(low <= high) {
			int mid = (low + high)/2 ;
			if(item > le[mid]) {
				low = mid+1 ;
			}else {
				high = mid - 1 ;
			}
		}
		
		return low;
	}
}