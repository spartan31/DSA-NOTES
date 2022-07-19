package backtracking;

public class Queencombiboxex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      queen(new boolean[4] , 0,0,2,"");
	}
	
	public static void queen(boolean[] box , int col , int tpsf , int tq ,String ans ) {
		if(tpsf == tq) {
			System.out.println(ans);
			return;
		}
		
		if(col == box.length) {
			return;
		}
		
		box[col] = true;
		queen(box,col+1,tpsf+1,tq,ans+"b"+col);
		box[col] = false;
		
		queen(box,col+1,tpsf,tq,ans);
	}

}
