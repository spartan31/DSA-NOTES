package recurrsion;

import java.util.ArrayList;

public class AsciiSubsquece {


	public static void main(String[] args) {
		String kk = "ab";	
	
		System.out.print(getss(kk));
	}
  public static ArrayList<String> getss(String str){
	if(str.length() == 0) {
		ArrayList<String> base = new ArrayList<String>();
		base.add("");
		  return  base;
	  }
	  char cc = str.charAt(0);
	  String ros = str.substring(1);
	  ArrayList<String> result = new ArrayList<String>(); 
	  ArrayList<String> recu = getss(ros);
	  for(int i = 0 ; i < recu.size(); i++) {
		  int ascii = (int)cc;
		  result.add(recu.get(i));
		  result.add(cc+recu.get(i));
		  result.add(recu.get(i) + ascii + cc);
		  
	  }
	  return result;
  }
}
