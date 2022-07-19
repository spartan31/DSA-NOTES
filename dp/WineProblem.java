package dp;

public class WineProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 3, 5, 1, 4 };
		System.out.println(wr(arr, 0, arr.length - 1, 1));
		System.out.println(wtd(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
	    System.out.println(wbu(arr));
	}

	// reccursive approach
	public static int wr(int arr[], int s, int e, int y) {
		if (s == e)
			return arr[e] * y;
		int l = wr(arr, s + 1, e, y + 1) + arr[s] * y;
		int r = wr(arr, s, e - 1, y + 1) + arr[e] * y;

		return Math.max(l, r);
	}

	// recursion potimised
	public static int wr(int arr[], int s, int e) {
		int y = arr.length - (e - s + 1) + 1;
		if (s == e)
			return arr[e] * y;
		int l = wr(arr, s + 1, e) + arr[s] * y;
		int r = wr(arr, s, e - 1) + arr[e] * y;

		return Math.max(l, r);
	}

	// dp toop dow approach
	public static int wtd(int arr[], int s, int e, int sto[][]) {
		int y = arr.length - (e - s + 1) + 1;
		if (s == e)
			return arr[e] * y;
		int ans = 0;
		if (sto[s][e] != 0) {
			ans = sto[s][e];
		} else {
			int l = wr(arr, s + 1, e) + arr[s] * y;
			int r = wr(arr, s, e - 1) + arr[e] * y;
			ans = Math.max(l, r);
		}

		sto[s][e] = ans;
		return ans;
	}

	// dp bottom up approach

	public static int wbu(int arr[]) {
		int n = arr.length;		
		int sto[][] = new int[n][n];
		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				int y = arr.length - (ei - si + 1) + 1;
				if (si == ei) {
					sto[si][ei] = arr[si] * y;
				} else {
					int l = sto[si + 1][ei] + arr[si] * y;
					int r = sto[si][ei - 1] + arr[ei] * y;
					int ans = Math.max(l, r);
					sto[si][ei] = ans;
				}
			}
		}
		return sto[0][n-1];
	}
}
