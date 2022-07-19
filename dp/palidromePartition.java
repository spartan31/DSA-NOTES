package dp;

import java.util.Arrays;

public class palidromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abssass";
		System.out.println(pp(s, 0, s.length() - 1));
		int arr[][] = new int[s.length()][s.length()];

		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr.length ;j++) {
			   arr[i][j] = -1 ;	
			}	
		}

		System.out.println(pptd(s, 0, s.length() - 1, arr));
		System.out.println(BU(s));
	}

	public static int pp(String s, int si, int ei) {
		if (ispali(s, si, ei)) {
			return 0;
		}

		int total = Integer.MAX_VALUE;
		for (int i = si; i < ei; i++) {
			int l = pp(s, si, i);
			int r = pp(s, i + 1, ei);
			int ans = l + r + 1;

			if (total > ans) {
				total = ans;
			}
		}

		return total;
	}

	public static int pptd(String s, int si, int ei, int sto[][]) {
		if (ispali(s, si, ei)) {
			return 0;
		}
		if (sto[ei][si] != -1) {
			return sto[si][ei];
		}

		int total = Integer.MAX_VALUE;
		for (int i = si; i < ei; i++) {
			int l = pptd(s, si, i, sto);
			int r = pptd(s, i + 1, ei, sto);
			int ans = l + r + 1;

			if (total > ans) {
				total = ans;
			}
		}
		sto[si][ei] = total;
		return total;
	}

	public static int BU(String s) {
		int n = s.length();
		boolean[][] strpali = paliarr(s);
		int sto[][] = new int[n][n];
		for (int k = 0; k <= n - 1; k++) {
			for (int si = 0; si <= n - k - 1; si++) {
				int ei = si + k;

				if ((strpali[si][ei])) {
					sto[si][ei] = 0 ;
				}else {
				int total = Integer.MAX_VALUE;
				for (int i = si; i < ei; i++) {
					int l = sto[ si][i] ;
					int r = sto[i + 1][ei] ;
					int ans = l + r + 1;

					if (total > ans) {
						total = ans;
					}
				}
				sto[si][ei] = total;
			 }
			}
		}
		
		return sto[0][n-1] ;
	}
	
	public static boolean[][] paliarr(String s){
		boolean[][] p = new boolean[s.length()][s.length()] ;
		for(int i = 0 ; i < p.length ; i++) {
			for(int j = 0 ; j < p.length ;j++) {
			   p[i][j] = true ;	
			}	
		}
		for(int row  = s.length()-2 ; row >=0 ; row--) {
			for(int col = row+1; col <s.length() ; col++) {
				if(s.charAt(row) == s.charAt(col)) {
					p[row][col] = p[row+1][col-1] ;
				}else {
					p[row][col] = false ;
				}
			}
		}
		
		return p ;
	}

	public static boolean ispali(String s, int l, int r) {
		int si = l;
		int ei = r;
		while (si < ei) {
			if (s.charAt(ei) != s.charAt(si)) {
				return false;
			}
			si++;
			ei--;
		}
		return true;
	}

}
