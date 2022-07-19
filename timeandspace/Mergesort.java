package timeandspace;

public class Mergesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int arr[]  = {10 , 6, 15,0,-4, 20 ,-1,16,11, 25};
          int ans[] = sort(arr,0,9);
           for(int i :ans) {
        	   System.out.print(i + "  ");
           }
           
           
	}
	
	public static int[] mergetwoarray(int[] arr1 , int[] arr2) {
		
		int[] merge = new int[arr1.length + arr2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i] <= arr2[j]) {
				merge[k] = arr1[i];
				i++;
				k++;
			}else {
				merge[k] = arr2[j];
				j++;
				k++ ;
			}
			
		}
		
		if(i == arr1.length) {
			while(j < arr2.length) {
				merge[k] = arr2[j];
				j++ ;
				k++ ;
			}
			
		}
		if(j == arr2.length) {
			while(i < arr1.length) {
				merge[k] = arr1[i];
				i++ ;
				k++ ;
			}
			
		}
		
		return merge;
	}
    public static int[] sort(int[] arr , int i , int h) {
    	if(i == h) {
    		 int[] base = new int[1];
    		 base[0] = arr[i];
    		 return base;
    	}
    	int mid = ( i + h) / 2 ;
    	int[] fh = sort(arr,i,mid);
    	int[] sh = sort(arr,mid+1,h);
    	
    	int[] merge = mergetwoarray(fh,sh);
    	 
    	return merge;
    }
}
