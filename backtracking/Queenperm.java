package backtracking;

public class Queenperm {
  static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    queen(new boolean[4],0,2," ");
	}
	public static void queen(boolean[] box, int qpsf, int tq , String ans) {
		if(qpsf == tq) {
			
			count++;
			System.out.println(count + " " + ans);
			return;
		}
		for(int i = 0; i<box.length ; i++) {
			if(box[i] == false) {
				box[i] = true;
				queen(box,qpsf+1,tq,ans+"q"+qpsf+"b"+i+" ");
				box[i] = false; // backtrack step
			}
		}
	}

} 
 