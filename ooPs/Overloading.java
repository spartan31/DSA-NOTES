package ooPs;

public class Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(2, 300));
		System.out.println(sum(3, 3, 3));
	}

	public static int sum(int a, int b) {
		return a + b;
	}

	public static int sum(int a, int b, int c) {
		return a + b + c;
	}

}
//    *******  overloading doest take return types as different function its shows error *******
 