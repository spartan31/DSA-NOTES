package recurrsion;

public class TowerofHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 3;
		
		System.out.print(toh(n , "src" , "des", "help"));

	}
	
	public static int toh(int n , String src , String des, String help) {
		if(n == 0) {
			return 0;
		}
		int k =1;
		k+= toh(n-1, src, help , des);
		System.out.println("move "+ n +" th disk from "+ src + " to " + des);
		k+= toh(n-1 , help , des , src);
		return k;
	}

}
