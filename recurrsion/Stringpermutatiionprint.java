package recurrsion;

public class Stringpermutatiionprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      per("abc","");
	}
   public static void per(String str , String result) {
	   
	   if(str.length() == 0) {
		   System.out.print(result+" ");
		   return;
	   }
	   
	   for(int i = 0 ; i < str.length(); i++) {
	   char cc = str.charAt(i);
	   String ros  =  str.substring(0, i) + str.substring(i+1);
	   per(ros,result+cc);
	   }
	   		
   }
}
 