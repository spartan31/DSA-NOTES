package backtracking;

public class OptimizeNqueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		kill(new boolean[5][5], 0, 0, 0, 5, "");
	}

	public static void kill(boolean[][] box, int row, int col, int qpsf, int tq, String ans) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		if (col == box[0].length) {
			row++;
			col = 0;
		}
		if (row == box.length) {
			return;
		}

		if (checkplace(box, row, col)) {
			box[row][col] = true;
			kill(box, row+1, 0, qpsf + 1, tq, ans + "[" + row + col + "]");
			box[row][col] = false;
		}

		kill(box, row, col + 1, qpsf, tq, ans);
	}

	public static boolean checkplace(boolean[][] box, int row, int col) {
//		horizontally
		int r = row;
		int c = col - 1;
		while (c >= 0) {
			if (box[r][c]) {
				return false;
			}
			c--;
		}
//		 vertically
		r = row - 1;
		c = col;
		while (r >= 0) {
			if (box[r][c]) {
				return false;
			}
			r--;
		}

//			 diagnoally left
			r = row - 1;
			c = col - 1;
			while (r >= 0 && c >= 0) {
				if (box[r][c]) {
					return false;
				}
				r--;
				c--;
			}

//			 diagonaly right 
			r = row - 1;
			c = col + 1;
			while (r >= 0 && c < box[0].length) {
				if (box[r][c]) {
					return false;
				}
				r--;
				c++;
			}
			return true ;
		}  

		
	}


