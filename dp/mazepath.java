package dp;

import java.util.Arrays;

public class mazepath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2 ;
       // System.out.println(mp(0,0,2,4));
      //  System.out.println(mptd(0,0,n,n,new int[n+1][n+1]));
        System.out.println(mpbu(2,4));
     //   System.out.println(mps(n,n));
	}
	
	// Reccursive solution 
	public static int mp(int cc , int cr , int ec , int er) {
		if(cc == ec && ec == er)  return 1 ;
		if(cc > ec || cr > er)   return 0 ;
		int v = mp(cc,cr+1,ec,er);
		int h = mp(cc+1,cr,ec,er);
		
		return v + h ;
	}
    // Top down dp approcah
	public static int mptd(int cc , int cr , int ec , int er, int[][] sto) {
		if(cc == ec && ec == er)  return 1 ;
		if(cc > ec || cr > er)   return 0 ;
		if(sto[cc][cr] != 0) {
			return sto[cc][cr];
		}
		
		int v = mptd(cc,cr+1,ec,er,sto);
		int h = mptd(cc+1,cr,ec,er,sto);
		
		sto[cc][cr] = v+h;
		return v + h ;
	}
	// bootom up approch
	
	public static int mpbu(int sr , int er) {
		int sto[][] = new int[sr+2][er+2] ;
		for(int i = sr ; i >= 0; i-- ) {
			for(int j = er ; j >= 0 ; j--) {
				if(i == sr && j == er) {
					sto[i][j] = 1 ;
				} else {
					sto[i][j] = sto[i][j+1] + sto[i+1][j] ;
				}
			}
		}		
		return sto[0][0];
	}
	
	// bottom up space optimised approch 
	
	public static int mps(int s , int e ) {
		int sto[] = new int[e+1] ;
		Arrays.fill(sto,1);
		for(int slide = s-1 ;slide >= 0 ; slide--){
			for(int col = e ; col >= 0 ; col--){
				if(col == e) {
					sto[col] = 1 ;
				}else {
					sto[col] = sto[col] + sto[col+1] ;
				}
			}
		}
		return sto[0];
	}
}
