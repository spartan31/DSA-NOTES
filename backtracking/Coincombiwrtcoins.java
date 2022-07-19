package backtracking;

public class Coincombiwrtcoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  int[] arr = {2,5,10};
		coinsbreak(arr,0,20,"");

	}
	
	public static void coinsbreak(int[] arr , int index , int amt, String result) {
		if(amt == 0) {
			System.out.println(result);
			return;
		}
		if(index == arr.length || amt < 0 ) {
			return;
		} 
		coinsbreak(arr,index,amt-arr[index],result+arr[index]);
		
		coinsbreak(arr,index+1,amt,result); 
                                      	}

}
