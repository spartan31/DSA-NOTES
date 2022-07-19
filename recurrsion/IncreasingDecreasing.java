package recurrsion;

public class IncreasingDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PDI(5);

	}
	
	public static void PDI(int a) {
		if(a == 0) {
			return;
		}
		System.out.println(a);
		PDI(a-1);
		System.out.println(a);
	}

}
