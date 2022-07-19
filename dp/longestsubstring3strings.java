package dp;

import java.util.Arrays;

public class longestsubstring3strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String a = "asd" ;
      String b = "dasdasasd" ;
      String c = "asd" ;
 //     System.out.println(ls(a,b,c,0,0,0));
      int arr[][][] = new int[a.length()+1][b.length()+1][c.length()+1] ;
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[0].length ; j++) {
				Arrays.fill(arr[i][j], -1);
			}
		}
		System.out.println(lstd(a,b,c,0,0,0,arr));
	    System.out.println(lsbu(a,b,c));
	}
	
	public static int ls(String a , String b , String c , int ai , int bi , int ci) {
		if(ai == a.length() || bi == b.length() || ci == c.length()) {
			return 0 ;
		}
		int ans = 0 ;
		if(a.charAt(ai) == b.charAt(bi) && c.charAt(ci) == a.charAt(ai)) {
			ans = ls(a,b,c,ai+1,bi+1,ci+1) + 1;
		}else {
			int l = ls(a,b,c,ai+1,bi,ci) ;
			int m = ls(a,b,c,ai,bi+1,ci) ;
			int n = ls(a,b,c,ai,bi,ci+1) ;
			
			ans = Math.max(l, Math.max(m, n)) ;
		}
		
		return ans ;
	}
	
	public static int lstd(String a , String b , String c , int ai , int bi , int ci , int sto[][][]) {
		if(ai == a.length() || bi == b.length() || ci == c.length()) {
			return 0 ;
		}
		
		if(sto[ai][bi][ci] != -1) {
			return sto[ai][bi][ci] ;
		}
		int ans = 0 ;
		if(a.charAt(ai) == b.charAt(bi) && c.charAt(ci) == a.charAt(ai)) {
			ans = lstd(a,b,c,ai+1,bi+1,ci+1,sto) + 1;
		}else {
			int l = lstd(a,b,c,ai+1,bi,ci,sto) ;
			int m = lstd(a,b,c,ai,bi+1,ci,sto) ;
			int n = lstd(a,b,c,ai,bi,ci+1,sto) ;
			
			ans = Math.max(l, Math.max(m, n)) ;
		}
		sto[ai][bi][ci] = ans ;
		return ans ;
	}
	
	public static int lsbu(String a , String  b , String c) {
		
		int sto[][][] = new int[a.length()+1][b.length()+1][c.length()+1] ;

		for(int l = a.length()-1 ; l >= 0 ; l--) {
           for(int m = b.length() - 1 ;  m>= 0 ; m--) {
        	   for(int n = c.length()-1 ; n >= 0 ; n--) {
        			int ans = 0 ;
        			if(a.charAt(l) == b.charAt(m) && c.charAt(n) == a.charAt(l)) {
        				ans = sto[l+1][m+1][n+1] + 1;
        			}else {
        				int l1 = sto[l+1][m][n] ;
        				int m1 = sto[l][m+1][n] ;
        				int n1 = sto[l][m][n+1] ;
        				
        				ans = Math.max(l1, Math.max(m1, n1)) ;
        			}
        			sto[l][m][n] = ans ;
        	   }
           }
		}
		return sto[0][0][0] ;
	}

}
