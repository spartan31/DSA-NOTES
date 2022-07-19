package dp;

import java.util.Arrays;

public class kordersubsquence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "abcdefgh"  ;
		String b = "abcdefgh " ;
		int k = 2 ;
	//	System.out.println(kos(a,b,k,0,0));
		int arr[][][] = new int[k+1][a.length()+1][b.length()+1] ;
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[0].length ; j++) {
				Arrays.fill(arr[i][j], -1);
			}
		}
	   System.out.println(kostd(a,b,k,0,0,arr));
	   System.out.println(kosbu(a,b,k));

	}
	public static int kos(String a , String b , int k , int si , int ei ) {
		if(si == a.length() || ei == b.length()) {
			return 0 ;
		}
		
		int ans  = 0 ;
		
		if(a.charAt(si) == b.charAt(ei)) {
			ans = kos(a,b,k,si+1,ei+1) + 1 ;
		}else {
			int l = kos(a,b,k, si+1,ei);
			int r = kos(a,b,k, si,ei+1);
			int o = 0 ;
			if(k>=1) {
				o = kos(a,b,k-1,si+1,ei+1);
			}
			ans = Math.max(l,Math.max(r, o)) ;
		}
		
		return ans ;
	}
	
	public static int kostd(String a , String b , int k , int si , int ei , int sto[][][] ) {
		if(si == a.length() || ei == b.length()) {
			return 0 ;
		}
		
		if(sto[k][si][ei] != -1) {
			return sto[k][si][ei] ;
		}		
				
		int ans  = 0 ;
		
		if(a.charAt(si) == b.charAt(ei)) {
			ans = kostd(a,b,k,si+1,ei+1,sto) + 1 ;
		}else {
			int l = kostd(a,b,k, si+1,ei ,sto);
			int r = kostd(a,b,k, si,ei+1,sto);
			int o = 0 ;
			if(k>=1) {
				o = kostd(a,b,k-1,si+1,ei+1,sto);
			}
			ans = Math.max(l,Math.max(r, o)) ;
		}
		sto[k][si][ei] = ans;
		return ans ;
	}
	
	public static int kosbu(String a , String b , int k){
		int sto[][][] = new int[k+1][a.length()+1][b.length()+1] ;
		for(int i = 0 ; i <= k ; i++) {
			for(int row = a.length() ; row >= 0 ; row-- ) {
				for(int col = b.length() ; col >= 0 ; col--) {
					if(row == a.length() || col == b.length()) {
						sto[k][row][col] = 0 ;
					}else {			
					int ans  = 0 ;
					if(a.charAt(row) == b.charAt(col)) {
						ans = sto[k][row+1][col+1] + 1 ;
					}else {
						int l = sto[k][row+1][col];
						int r = sto[k][row][col+1];
						int o = 0 ;
						if(k>=1) {
							o =sto[k-1][row+1][col+1];
						}
						ans = Math.max(l,Math.max(r, o)) ;
					}
					sto[k][row][col] = ans;
				  }
			   }
			}
		}
		return sto[k][0][0] ;
	}

}
