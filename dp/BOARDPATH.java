package dp;

public class BOARDPATH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3 ;
        System.out.println(bpr(0,n));
        System.out.println(bpdp(0,n, new int[n]));
        System.out.println(bpdpb(n));
        System.out.println(so(n));
	}
	
	public static int bpr(int start , int  end) {
		if(start == end)  return 1 ;
		if(start > end)    return 0;
		int c = 0 ;
		for(int i = 1 ; i <=  6 ; i++) {
			c+= bpr(start+i,end);
		}
		return c ;
	}
	// de  memrization approach top down
	public static int bpdp(int start , int  end , int[] strg) {
		if(start == end)  return 1 ;
		if(start > end)    return 0;
		// taking use of already  stored number  
		if(strg[start] != 0) {
			return strg[start] ;
		}
		int c = 0 ;
		for(int i = 1 ; i <=  6 ; i++) {
			c+= bpr(start+i,end);
		}
		strg[start]  = c ;
		return c ;
	}
	// boardpath dp bottom up approach
	public static int bpdpb(int n) {
		int strg[] = new int[n+6];
		strg[n] = 1 ;
		for(int i = n-1 ; i >= 0 ; i--) {
			strg[i] = strg[i+1] + strg[i+2] + strg[i+3] + strg[i+4] + strg[i+5] + strg[i+6] ;
		}
		return strg[0];
	}
	
	// dp bottom up space optimised approach
	public static int so(int n) {
		int strg[] = new int[6];
		strg[0] = 1 ;
		for(int i = 1 ; i <= n; i++) {
			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5] ;
			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = sum ;
		}
		return strg[0];
	}

}
