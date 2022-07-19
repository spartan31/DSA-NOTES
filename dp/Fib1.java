package dp;

public class Fib1 {
	//Normal reccursive approch time = 2^n 
	public static int fibn(int n){
		if(n == 0 || n == 1)   return n;
		
		return fibn(n-1) + fibn(n-2) ;
	}
    // dp aprroch time complexity 
	public static int fib(int n) {
		int sto[] = new int[n+1]; 
		for(int i = 0 ; i < n+1 ; i++) {
			sto[i] = -1 ;
		}
		
		return fibm(n,sto);
	}
	private static int fibm(int n, int[] sto) {
     if(n == 0 || n == 1) { 
    	 sto[n] = n; 
    	 return sto[n];
    	}
		if(sto[n] != -1) {
			return sto[n];
		}
		return fibm(n-1,sto) + fibm(n-2,sto) ;
	}
	
	public static int fibdp(int n) {
		int sto[] = new int[n+1];
		sto[0] = 0;
		sto[1] = 1;
		for(int i = 2 ; i < n+1 ; i++) {
			sto[i] = sto[i-1] + sto[i-2] ;
		}
		
		return sto[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
             System.out.println(fibdp(44));
             System.out.println(fib(44));
             System.out.println(fibn(44));
             
	}

}
