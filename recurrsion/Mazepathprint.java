package recurrsion;

public class Mazepathprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      path(0,0,2,2,"");
	}
   public static void path(int cc , int cr , int ec , int er, String result) {
	   if(cc == ec && cr == er) {
		   System.out.println(result);
		   return;
	   }
	   if(cc > ec || cr > er) {
		   return;
	   }
	   path(cc,cr + 1 , ec , er, result+"H");
	   path(cc+1, cr, ec,er,result+"v");
   }
}
