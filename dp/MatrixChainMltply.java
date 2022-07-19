package dp;

public class MatrixChainMltply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int  arr[] = {4 , 2 , 3 , 5 , 1};  
		System.out.println(mcmr(arr,0,arr.length-1));
		System.out.println(mcmtd(arr,0,arr.length-1 , new int[arr.length][arr.length]));
		System.out.println(mcmbu(arr));
	}
	
	public static int mcmr(int arr[] , int si , int ei) {
		if(si+1 == ei)   return 0 ;
		int ans = Integer.MAX_VALUE ;
		for(int i = si + 1 ; i <= ei-1 ; i++) {
		int l = 	mcmr(arr,si,i); /// output will be arr[si][i]
		int r = 	mcmr(arr,i,ei); /// output will be arr[i][ei]
		int c = arr[si] * arr[ei] * arr[i] ;
		int total = l + r+ c ;
		ans = Math.min(ans,total);
		}
		
		return ans ;
	}
	
	// dp top down approach 
	public static int mcmtd(int arr[] , int si , int ei, int sto[][]) {
		if(si+1 == ei)   return 0 ;
		
		if(sto[si][ei] != 0) {
			return  sto[si][ei] ;
		}
		int ans = Integer.MAX_VALUE ;
		for(int i = si + 1 ; i <= ei-1 ; i++) {
		int l = 	mcmtd(arr,si,i,sto); /// output will be arr[si][i]
		int r = 	mcmtd(arr,i,ei,sto); /// output will be arr[i][ei]
		int c = arr[si] * arr[ei] * arr[i] ;
		int total = l + r+ c ;
		ans = Math.min(ans,total);		
		}
		sto[si][ei] = ans ;
		return ans ;
	}
	
	public static int mcmbu(int arr[]) {
		int sto[][] = new int[arr.length][arr.length];
		int n = arr.length ;
		for(int k = 1 ; k <= n -1 ; k ++) {
			for(int si  = 0; si <= n - k - 1 ; si++) {
				int ei = si + k ;				
				if(si+1 == ei) {  
					sto[si][ei] =  0 ;
				}else {				
				int ans = Integer.MAX_VALUE ;
				for(int i = si + 1 ; i <= ei-1 ; i++) {
				int l = 	sto[si][i] ; /// output will be arr[si][i]
				int r = 	sto[i][ei] ; /// output will be arr[i][ei]
				int c = arr[si] * arr[ei] * arr[i] ;
				int total = l + r+ c ;
				ans = Math.min(ans,total);				
				}
				sto[si][ei] = ans ;
			}
		  }
		}
		return sto[0][n-1] ;
	}

}
