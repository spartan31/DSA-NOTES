package recurrsion;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
       System.out.println(FACT(4));
	}
   public static int FACT(int a){
	   if( a == 1) {
		   return 1;
	   }
	   
	   int f1 = FACT(a-1);
	   int fn = a*f1;
	   return fn;
   }
}
