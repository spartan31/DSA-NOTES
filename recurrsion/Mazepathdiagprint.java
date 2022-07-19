package recurrsion;

public class Mazepathdiagprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//  path(0,0,2,2,"");
		System.out.println(count(0,0,2,2));
	}
	
public static void path(int cc , int cr , int ec , int er, String result) {
	   if(cc == ec && cr == er) {
		   System.out.println(result);
		   return;
	   }
	   if(cc > ec || cr > er) {
		   return;
		   }
	path(cc,cr+1,ec,er,result+"h");
	path(cc+1,cr,ec,er,result+"v");
	path(cc+1,cr+1,ec,er,result+"d");
}
public static int count(int cc , int cr , int ec , int er) {
	   if(cc == ec && cr == er) {
		 
		   return 1;
	   }
	   if(cc > ec || cr > er) {
		   return 0;
		   }
	   
	   int cnt = 0;
	cnt += count(cc,cr+1,ec,er);
	cnt += count(cc+1,cr,ec,er);
	cnt += count(cc+1,cr+1,ec,er);
	return cnt;
}
}
