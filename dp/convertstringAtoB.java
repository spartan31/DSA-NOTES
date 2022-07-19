package dp;

import java.util.Arrays;

public class convertstringAtoB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "heap";
		String b = "pea";
		System.out.println(cr(a, b));
		System.out.println(cro(a, b, 0, 0));

		int s[][] = new int[a.length()][b.length()];
		for (int i = 0; i < s.length; i++) {
			Arrays.fill(s[i], -1);
		}

		System.out.println(crtd(a, b, 0, 0, s));
		System.out.println(crbu(a, b));
	}

	public static int cr(String a, String b) {
		if (a.length() == 0 || b.length() == 0) {
			return Math.max(a.length(), b.length());
		}
		char c1 = a.charAt(0);
		char c2 = b.charAt(0);
		String ros = a.substring(1);
		String ros2 = b.substring(1);
		int ans = 0;
		if (c1 == c2) {
			ans = cr(ros, ros2);
		} else {
			int d = cr(a, ros2);
			int i = cr(ros, b);
			int r = cr(ros, ros2);

			ans = Math.min(d, Math.min(i, r)) + 1;
		}
		return ans;
	}

	// optimised reccursion approch
	public static int cro(String a, String b, int ia, int ib) {
		if (a.length() == ia || b.length() == ib) {
			return Math.max(a.length() - ia, b.length() - ib);
		}
		char c1 = a.charAt(ia);
		char c2 = b.charAt(ib);
		int ans = 0;
		if (c1 == c2) {
			ans = cro(a, b, ia + 1, ib + 1);
		} else {
			int d = cro(a, b, ia, ib + 1);
			int i = cro(a, b, ia + 1, ib);
			int r = cro(a, b, ia + 1, ib + 1);

			ans = Math.min(d, Math.min(i, r)) + 1;
		}
		return ans;
	}

	// dp top down approch
	public static int crtd(String a, String b, int ia, int ib, int[][] s) {
		if (a.length() == ia || b.length() == ib) {
			return Math.max(a.length() - ia, b.length() - ib);
		}
		if (s[ia][ib] != -1) {
			return s[ia][ib];
		}
		char c1 = a.charAt(ia);
		char c2 = b.charAt(ib);
		int ans = 0;
		if (c1 == c2) {
			ans = crtd(a, b, ia + 1, ib + 1, s);
		} else {
			int d = crtd(a, b, ia, ib + 1, s);
			int i = crtd(a, b, ia + 1, ib, s);
			int r = crtd(a, b, ia + 1, ib + 1, s);

			ans = Math.min(d, Math.min(i, r)) + 1;
		}
		s[ia][ib] = ans;
		return ans;
	}

	// dp bottom up approach filling bottom to top and right to left

	public static int crbu(String a, String b) {
		int arr[][] = new int[a.length() + 1][b.length() + 1];
		for(int r = a.length(); r >= 0; r--) {
			for (int c = b.length(); c >= 0; c--) {
				if (r == a.length()) {
					arr[r][c] = b.length() - c;
				} else if (c == b.length()) {
					arr[r][c] = a.length() - r;
				} else {
					if (a.charAt(r) == b.charAt(c)) {
						arr[r][c] = arr[r + 1][c + 1];
					} else {
						int d = arr[r][c + 1];
						int i = arr[r + 1][c];
						int re = arr[r + 1][c + 1];
						arr[r][c] = Math.min(i, Math.min(d, re)) + 1;
					}
				}
			}
		}
		return arr[0][0];
	}

}
