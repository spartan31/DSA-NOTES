package backtracking;

public class Coincombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int[] ar = {2 ,3, 5 ,6};
   coin(ar,10,"",0);
	}
  public static void coin(int[] arr , int amt , String ans , int last) {
	  if(amt == 0) {
		  System.out.println(ans);
		  return;
	  }
	  
	  for(int i = last ; i<arr.length ; i++) {
		  if(amt >= arr[i]) {
			  coin(arr,amt-arr[i] , ans+arr[i],i);
		  }
		  
	  }
  }
}
