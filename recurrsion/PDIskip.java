package recurrsion;

public class PDIskip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SKIP(5);
	}
	
	public static void SKIP(int a) {
		if(a == 0) {
			return;
		}
		if(a%2 == 1){
		System.out.println(a);
		}
		SKIP(a-1);
		if(a%2 == 0) {
			System.out.println(a);
		}
	}

}
