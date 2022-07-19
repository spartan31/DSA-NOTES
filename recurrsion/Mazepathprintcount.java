package recurrsion;

public class Mazepathprintcount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(path(0,0,2,2));

	}
	   public static int path(int cc , int cr , int ec , int er) {
		   if(cc == ec && cr == er) {
//			   System.out.println(result);
			   return 1;
		   }
		   if(cc > ec || cr > er) {
			   return 0;
		   }
		   int count = 0; 
		  count += path(cc,cr + 1 , ec , er);
		   count += path(cc+1, cr, ec,er);
		   return count;
	   }
	
}
