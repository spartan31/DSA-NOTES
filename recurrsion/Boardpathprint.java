package recurrsion;

public class Boardpathprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		board(0,3," ");

	}
     public static void board(int s , int e, String result ) {
    	 if(s == e) {
    		 System.out.print(result+" ");
    		 return ;
    	 }
    	 if(s > e) {
    		 return ;
    	 }
    	
    	 for(int i = 1 ; i <= 6 ; i++ ) {
    		 
    	  board(s+i, e,result + i);
    	 
    	
    	 }
    	 
    	
     }
}
