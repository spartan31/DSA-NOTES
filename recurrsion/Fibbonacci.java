package recurrsion;

public class Fibbonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(SUM(6));
	}
	public static int SUM(int a) {
		if(a == 1 || a == 0) {
			return a;
		}
		int fib1 = SUM(a - 1);
		int fib2 = SUM(a-2);
		int ye = fib1+fib2;
		return ye;
	}

}
