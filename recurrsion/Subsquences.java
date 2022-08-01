package recurrsion;

import java.util.*;

public class Subsquences {

	public static void main(String[] args) {
		String kk = "abc";	
	
		System.out.print(getss(kk));
	}
  public static ArrayList<String> getss(String str){
	  if(str.length() == 0){
		ArrayList<String> base = new ArrayList<String>();
		base.add("");
		  return  base;
	  }
	  char cc = str.charAt(0);
	  String ros = str.substring(1);
	  ArrayList<String> result = new ArrayList<String>(); 
	  ArrayList<String> recu = getss(ros);
	  for(int i = 0 ; i < recu.size(); i++) {
		  result.add(recu.get(i));
		  result.add(cc+recu.get(i));
		  
	  }
	  return result;
  }
}
