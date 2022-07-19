package dp;

public class Dungeongame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { -2, -3, 5 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(game(arr, 0, 0, arr.length - 1, arr[0].length - 1));
		System.out.println(gametd(arr, 0, 0, arr.length - 1, arr[0].length - 1, new int[arr.length][arr[0].length]));
          System.out.println(gamebu(arr));
	}

	public static int game(int arr[][], int ce, int cc, int er, int ec) {
		if (ce == er && cc == ec) {
			return arr[ce][cc] <= 0 ? -arr[ce][cc] + 1 : 1;
		}
		if (ce > er || cc > ec) {
			return Integer.MAX_VALUE;
		}

		int r = game(arr, ce, cc + 1, er, ec);
		int l = game(arr, ce + 1, cc, er, ec);

		int path = Math.min(r, l);

		int amountalready = path - arr[ce][cc];

		int ans;
		if (amountalready >= 1) {
			ans = amountalready;
		} else {
			ans = 1;
		}

		return ans;
	}

	public static int gametd(int arr[][], int ce, int cc, int er, int ec, int sto[][]) {
		if (ce == er && cc == ec) {
			return arr[ce][cc] <= 0 ? -arr[ce][cc] + 1 : 1;
		}
		if (ce > er || cc > ec) {
			return Integer.MAX_VALUE;
		}
		if (sto[ce][cc] != 0) {
			return sto[ce][cc];
		}
		int r = gametd(arr, ce, cc + 1, er, ec, sto);
		int l = gametd(arr, ce + 1, cc, er, ec, sto);

		int path = Math.min(r, l);

		int amountalready = path - arr[ce][cc];

		int ans;
		if (amountalready >= 1) {
			ans = amountalready;
		} else {
			ans = 1;
		}
		sto[ce][cc] = ans;
		return ans;
	}
	
	public static int gamebu(int arr[][]) {
		int sto[][] = new int[arr.length+1][arr.length+1] ;
		for(int row = sto.length-1 ; row >= 0 ; row--) {
			for(int col = sto[0].length-1 ; col >= 0 ; col--) {
				if(row == sto.length-2 && col == sto[0].length-2) {
					sto[row][col] = arr[row][col] <= 0 ? -arr[row][col] + 1 : 1;
				}else if(row == sto.length-1) {
					sto[row][col] = Integer.MAX_VALUE ;
				}else if(col == sto[0].length-1) {
					sto[row][col] = Integer.MAX_VALUE ;
				}else {
					int r = sto[row][col+1] ;
					int l = sto[row+1][col] ;

					int path = Math.min(r, l);

					int amountalready = path - arr[row][col];

					int ans;
					if (amountalready >= 1) {
						ans = amountalready;
					} else {
						ans = 1;
					}
					sto[row][col] = ans;
				}
			}
		}
		
		return sto[0][0] ;
	}

}
