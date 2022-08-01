package dp;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[] = { 6 , 8  , 4 , 10 , 7 , 5} ;
       int price[] = {12 , 24 , 20 , 30 ,27 , 25};

       System.out.println(kr(arr,price,0,30));
//       System.out.println(ktd(arr,price,0,7,new int[arr.length][7+1]));// 7 +1 is capacity plus 1
//		/* System.out.println(kbu(arr,price,30)); */
	}
      
	public static int kr(int arr[] , int price[] , int s , int ca) {
		if( s == arr.length || ca == 0 )  return 0 ;
		int e = kr(arr, price , s+1,ca );
		int i = 0;
		if(ca >= arr[s]) {
		i = kr(arr,price,s+1,ca - arr[s]) + price[s];
		}	
		int ans = Math.max(e, i) ;
		return ans ; 
	}
	//4060   5440
	// top down approach
	
	public static int ktd(int arr[] , int price[] , int s , int ca, int sto[][]) {
		if( s == arr.length || ca == 0 )  return 0 ;
		
		if(sto[s][ca] != 0)  return sto[s][ca] ;
		int e = ktd(arr, price , s+1,ca,sto );
		
		int i = 0;
		if(ca >= arr[s]) {
		i = ktd(arr,price,s+1,ca - arr[s],sto) + price[s];
		}	
		int ans = Math.max(e, i) ;
		sto[s][ca] = ans ;
		return ans ; 
	}
	
	// bottomup approach dp
	public static int kbu(int arr[] , int price[] , int cap) {
		int n = arr.length ;
		int sto[][] = new int[n +1 ][cap + 1];
		
		for(int row = n-1 ; row >= 0 ; row--) {
			for(int col = 1 ; col  <= cap ; col++ ) {
				int e  = sto[row+1][col] ;
				int i = 0 ;
				if(col >= arr[row]) {
					i = sto[row+1][col-arr[row]] + price[row] ;
				}
				int ans = Math.max(e, i);
				sto[row][col] = ans ;
			}
		}
		return sto[0][cap] ;
	}
}
