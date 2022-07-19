package recurrsion;

public class demo {
     // PD is for Pushing recursion
	// PI is for POPUP recursion
	public static void main(String[] args) {
		PD(5);
		PI(5);
	}
	
	public static void PD(int a) {
		if(a == 0) {
			return;
		}
		
		System.out.println(a);
		PD(a-1);
		
	}
	
	public static void PI(int b) {
		if(b == 0) {
			return;
		}
		
		PI(b-1);
		System.out.println(b);
		
	}

}
