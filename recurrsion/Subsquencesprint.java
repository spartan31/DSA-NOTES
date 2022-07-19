package recurrsion;

public class Subsquencesprint {

	public static void main(String[] args) {
		// TOD'O Auto-generated method stub
        subs("abc", "");
	}
	public static void subs(String str, String result) {
		if(str.length() == 0) {
			System.out.print(result + " ");
			return ;
		}
		
		char cc = str.charAt(0);
		String ros = str.substring(1);
		subs(ros,result);
		subs(ros, result + cc);
//		int ascii = (int)cc;
//		subs(ros,result+cc+ascii);
	}

}
