package dp;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcd";
		String b = "a*x";
		System.out.println(wm(a, b));
		System.out.println(wmtd(a, b, 0, 0, new int[a.length()][b.length()]));
		System.out.println(wmbu(a, b));
	}

	public static boolean wm(String a, String b) {
		if (a.length() == 0 && b.length() == 0) {
			return true;
		}
		if (a.length() != 0 && b.length() == 0) {
			return false;
		}
		if (a.length() == 0 && b.length() != 0) {
			for (int i = 0; i < b.length(); i++) {
				if (b.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		char ca = a.charAt(0);
		char cb = b.charAt(0);
		boolean ans;
		String ros = a.substring(1);
		String path = b.substring(1);
		if (ca == cb || cb == '?') {
			ans = wm(ros, path);
		} else if (cb == '*') {
			boolean blank = wm(a, path);
			boolean multi = wm(ros, b);
			ans = blank || multi;
		} else {
			ans = false;
		}

		return ans;
	}

	public static boolean wmtd(String a, String b, int s, int e, int[][] sto) {
		if (a.length() == s && b.length() == e) {
			return true;
		}
		if (a.length() != s && b.length() == e) {
			return false;
		}
		if (a.length() == s && b.length() != e) {
			for (int i = e; i < b.length(); i++) {
				if (b.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}

		if (sto[s][e] != 0) {
			return (sto[s][e] == 2) ? true : false;
		}
		char ca = a.charAt(s);
		char cb = b.charAt(e);
		boolean ans;
		if (ca == cb || cb == '?') {
			ans = wmtd(a, b, s + 1, e + 1, sto);
		} else if(cb == '*') {
			boolean blank = wmtd(a, b, s, e + 1, sto);
			boolean multi = wmtd(a, b, s + 1, e, sto);
			ans = blank || multi;
		} else {
			ans = false;
		}

		sto[s][e] = (ans == true) ? 2 : 1;

		return ans;
	}

	public static boolean wmbu(String a, String b) {
		boolean sto[][] = new boolean[a.length() + 1][b.length() + 1];
		sto[a.length()][b.length()] = true;
		boolean ans;
		for (int i = a.length(); i >= 0; i--) {
			for (int j = b.length() - 1; j >= 0; j--) {
				if (i == a.length()) {
					if (b.charAt(j) == '*') {
						sto[i][j] = sto[i][j + 1];
					} else {
						sto[i][j] = false;
					}
					continue; // we go to next code
				}
				char ca = a.charAt(i);
				char cb = b.charAt(j);

				if (ca == cb || cb == '?') {
					ans = sto[i + 1][j + 1];
				} else if (cb == '*') {
					boolean blank = sto[i][j + 1];
					boolean multi = sto[i + 1][j];
					ans = blank || multi;
				} else {
					ans = false;
				}

				sto[i][j] = ans;
			}
		}

		return sto[0][0];
	}

}
