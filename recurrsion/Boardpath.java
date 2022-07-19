package recurrsion;

import java.util.ArrayList;

public class Boardpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(get(0,3));
       
	}
	
	public static ArrayList<String> get(int start , int end){
		
		if(start == end) {
			ArrayList<String> b1 = new ArrayList<>();
			b1.add("");
			return b1 ;
		}
		if(start > end) {
			ArrayList<String> b2 = new ArrayList<>();
			return b2 ; 
		}
		
		ArrayList<String> result = new ArrayList<>();
		for(int dice = 1; dice <= 6 ; dice++) {
			ArrayList<String> recur = get(start + dice , end);
			
			for(String rrs : recur) {
			result.add(rrs + dice);
			}
		}
		
		return result;
	}

}
