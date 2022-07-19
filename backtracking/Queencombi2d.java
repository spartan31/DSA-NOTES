package backtracking;

public class Queencombi2d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     queen(new boolean[2][2], 0,0,0,2,"");
	}
   public static void queen(boolean[][] arr, int row , int col , int qpsf , int tq , String ans) {
	    if(qpsf == tq) {
	    	System.out.println(ans);
	    	return;
	    }
	   if(col == arr[0].length) {
		   row++;
		   col = 0;
	   }
	   if(row == arr.length) {
		   return ;
	   }
	   
	   
	   arr[row][col] = true;
	   queen(arr,row,col+1,qpsf+1,tq,ans+"b{"+row+col+"} ");
	   arr[row][col] = false;
	   queen(arr,row,col+1,qpsf,tq,ans);
   }
}
