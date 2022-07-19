package dp;

public class possibleBSTcatalan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    int n = 384 ; 
       //     System.out.println(count(n));
          //  System.out.println(counttd(n,new int[n+1]));
            System.out.println(countbu(n));
	}
     
	public static int count(int n ) {
		if(n == 1 || n == 0 ) {
			return 1 ; 
		}
		int total = 0 ;
		for(int i = 1 ; i <= n ; i++) {
			int l = count(i-1) ;
			int r = count(n-i);
			
			int ans = l*r ;
			total += ans;
		}
		
		return total ;
	}
	
	public static int counttd(int n ,int sto[]) {
		if(n == 1 || n == 0 ) {
			return 1 ; 
		}
		
		if(sto[n] != 0) {
			return sto[n] ;
		}
		int total = 0 ;
		for(int i = 1 ; i <= n ; i++) {
			int l = counttd(i-1,sto) ;
			int r = counttd(n-i,sto);
			
			int ans = l*r ;
			total += ans;
		}
		sto[n] = total ;
		return total ;
	}
	
	public static int countbu(int tn) {
		int sto[] = new int[tn + 1] ;
		sto[0] = sto[1] = 1 ;
		for(int n = 2 ; n < tn+1 ; n++) {
			int total = 0 ;
			for(int i = 1 ; i <= n ; i++) {
				int l = sto[i-1] ;
				int r = sto[n-i];				
				int ans = l*r ;
				total += ans;
			}
			sto[n] = total ;
		}
		
		return sto[tn] ;
	}
	
}
