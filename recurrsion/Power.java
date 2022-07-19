package recurrsion;

public class Power {
	
	public static void main(String[] args) {
		System.out.println(P(3,2));
		
}
	public static int P(int a , int b) {
		if(b==1)
			return a;
		if(b == 0) {
			return 1 ;
		}
		int temp=P(a,b/2);
		if(b%2==0)
			return temp*temp;
		else
			return temp*temp*a;
	}

}
