package dp;

public class longestpalidromsubsquenc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcbcbcccba";
		System.out.println(lps(s, 0, s.length() - 1));
		System.out.println(lpstd(s, 0, s.length() - 1, new int[s.length() + 1][s.length() + 1]));
		System.out.println(lpsbu(s));
	}

	public static int lps(String s, int si, int ei) {
		if (si > ei) {
			return 0;
		}
		if (si == ei) {
			return 1;
		}
		int ans = 0;
		if (s.charAt(si) == s.charAt(ei)) {
			ans = lps(s, si + 1, ei - 1) + 2;
		} else {
			int l = lps(s, si + 1, ei);
			int r = lps(s, si, ei - 1);
			ans = Math.max(l, r);
		}

		return ans;
	}

	public static int lpstd(String s, int si, int ei, int sto[][]) {
		if (si > ei) {
			return 0;
		}
		if (si == ei) {
			return 1;
		}

		if (sto[ei][si] != 0) {
			return sto[ei][si];
		}
		int ans = 0;
		if (s.charAt(si) == s.charAt(ei)) {
			ans = lps(s, si + 1, ei - 1) + 2;
		} else {
			int l = lpstd(s, si + 1, ei, sto);
			int r = lpstd(s, si, ei - 1, sto);
			ans = Math.max(l, r);
		}

		sto[ei][si] = ans;

		return ans;
	}

	public static int lpsbu(String s) {
		int n = s.length();	
		int sto[][] = new int[n][n];
		for (int slide = 0; slide <= n-1; slide++) {
			for (int si = 0; si <= n - slide-1; si++) {
				int ei = si + slide;
				if (si == ei) {
					sto[ei][si] = 1;
				}else {
					int ans = 0;
				if (s.charAt(si) == s.charAt(ei)) {
					ans = sto[si + 1][ei - 1] + 2;
				} else {
					int l = sto[si + 1][ei];
					int r = sto[si][ei - 1];
					ans = Math.max(l, r);
				}
				sto[si][ei] = ans;
			  }
		  }
		}
          return sto[0][n-1] ;
	}
}
