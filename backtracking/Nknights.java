package backtracking;

public class Nknights {
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		knight(new boolean[3][3], 0, 0, 0, 3, "");
	}

	public static void knight(boolean[][] box, int row, int col, int kpsf, int tk, String ans) {
		if (kpsf == tk) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		if (col == box[0].length) {
			row++;
			col = 0;
		}

		if (row == box.length) {
			return;
		}
		if (checker(box, row, col)) {
			box[row][col] = true;
			knight(box, row, col + 1, kpsf + 1, tk, ans + "[" + row + col + "]");
			box[row][col] = false;
		}
		knight(box, row, col + 1, kpsf, tk, ans);

	}

	public static boolean checker(boolean[][] box, int row, int col) {
		int[] rar = { -1, -2, -2, -1 };
		int[] car = { 2, 1, -1, -2 };

		for (int i = 0; i < 4; i++) {
			int r = row + rar[i];
			int c = col + car[i];
			if (r >= 0 && r < box.length && c >= 0 && c < box[0].length) {
				if (box[r][c]) {
					return false;
				}
			}
		}
		return true;
	}

}
