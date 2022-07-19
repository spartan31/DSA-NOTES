package timeandspace;

public class PowerOnlogn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(power(2,5));
	}
	public static int power(int x ,int n){
        if(n == 0) {
        	return 1;
        }
		
		int p = power(x,n/2);
		if(n%2 == 1) {
			p = p*p*x;
		}else {
			p = p*p ;
		}
		
		return p ;
	}

}
