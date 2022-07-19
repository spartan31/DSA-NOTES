package recurrsion;

import java.util.ArrayList;

public class Mazepath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(path(0,0,1,2));

	}
   public static ArrayList<String> path(int a , int b , int c , int d){
	   
	   if(a == c && b == d) {
		   ArrayList<String> b1 = new ArrayList<>();
		   b1.add("");
		   return b1;
	   }
	   if(a > c || b > d) {
		   ArrayList<String> b2 = new ArrayList<>();
		   return b2;
	   }
	   
	   ArrayList<String> result = new ArrayList<>();
	   
	  
	   ArrayList<String> recurV = path(a,b+1,c,d);
	   for(String rrV : recurV) {
		   result.add("V" + rrV);
	   }
	   
	   
	   ArrayList<String> recurh = path(a+1,b,c,d);
	   for(String rrh : recurh) {
		   result.add("H" + rrh );
	   }
	   
	   return result;
	   
   }
}
