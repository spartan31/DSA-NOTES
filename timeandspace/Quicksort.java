package timeandspace;

public class Quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,3,65,24,85,141,-1,02,3};
		sort(arr,0,arr.length-1);
		for(int i : arr) {
			System.out.print(i  + " ");
		}
		
	}
    public static void sort(int[] arr , int lo , int hi) {
    	if(lo >= hi) {
    		return;
    	}
//    	partitioning
    	int mid = (lo +hi)/2 ;
    	int pivot = arr[mid];
    	
    	int left = lo;
    	int right = hi ;
    	 
    	while(left <= right) {
    		while(arr[left] < pivot) {
    			left++ ;
    		}
    		while(arr[right] > pivot) {
    			right-- ;
    		}
    		
    		if(left <= right) {
    			int temp = arr[left];
    			arr[left] = arr[right];
    			arr[right] = temp ;
    			
    			left++ ;
    			right-- ;
    		}
    			
    	}
//    	smaller problem 
    	sort(arr , lo , right);
    	sort(arr, left , hi);
    }
}
