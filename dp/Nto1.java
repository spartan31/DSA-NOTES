package dp;

public class Nto1 {

	public static int toOne(int n) {
		if (n == 1) {
			return 0;
		}

		int k = toOne(n - 1);
		int min = k;

		if (n % 3 == 0) {
			int l = toOne(n / 3);
			if (min > l) {
				min = l;
			}
		}
		if (n % 2 == 0) {
			int l = toOne(n / 2);
			if (min > l) {
				min = l;
			}
		}

		return 1 + min;
	}
	
	public static int OneM(int n) {
		int stor[] = new int[n+1];
	  return one(n,stor);
	}

	private static int one(int n, int[] stor) {
		if(n == 1) {
			stor[n] = 0 ;
			return stor[n];
		}
		if(stor[n] != 0) {
			return stor[n];
		}
		
		int k = one(n-1,stor);
		int min = k ;
		if(n%3 == 0) {
			int op = one(n/3,stor);
		    if(op < min) {
		    	min = op ;
		    }
		}
		if(n%2 == 0) {
			int p = one(n/2,stor);
			if(p < min) {
				min = p;
			}
		}
		
		stor[n] = 1 + min ;
		return stor[n];
	}
	
	public static int dp(int n) {
		int[]  stor = new int[n+1];
		stor[1] = 0;
		for(int i = 2 ; i <= n ; i++) {
			int min = stor[i-1];
			if(i%3 == 0) {
				if(min > stor[i/3]) {
					min = stor[i/3] ;
				}
			}
			if(i %2 == 0 ) {
				if(min > stor[i/2]) {
					min = stor[i/2] ;
				}
			}
			stor[i] = 1+ min; 
		}
		
		return stor[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(dp(1000));
		System.out.println(OneM(1000));
		System.out.println(toOne(1000));
		
	}

}
