package timeandspace;

public class Dutchflagsort012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int arr[] = {0,1,0,2,1,0,2};
  sort(arr);
  for(int i:arr) {
	  System.out.print(i+" ");
  }
	}
  public static void sort(int[] arr ) {
	  int lo = 0 ;
	  int mid = 0;
	  int hi = arr.length-1;
	  while(mid <= hi) {
		  if(arr[mid] == 0) {
			  int temp = arr[mid];
			  arr[mid] = arr[lo];
			  arr[lo] = temp;
			  
			  lo++ ;
			  mid++ ;		  }
		  else if(arr[mid] == 1) {
			 mid++ ;
		  }else {
			  int temp = arr[mid];
			  arr[mid] = arr[hi];
			  arr[hi] = temp;
			  hi--;
		  }
	  }
  }
}
