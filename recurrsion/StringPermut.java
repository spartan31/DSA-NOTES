package recurrsion;

import java.util.ArrayList;

public class StringPermut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(per("abc"));

	}
public static ArrayList<String> per(String str){
	if(str.length() == 0) {
		ArrayList<String> base = new ArrayList<>();
		base.add("");
		return base;
	}
	
	char cc = str.charAt(0);
	String ros = str.substring(1);
	
	ArrayList<String> recur = per(ros);
	
	ArrayList<String> result = new ArrayList<>();
	
	for(String rrs : recur) {
		
	    for(int i = 0 ; i <= rrs.length(); i++) {
		String val = rrs.substring(0 , i) + cc + rrs.substring(i);
		result.add(val);
	}
}
  return result;	
}
}
