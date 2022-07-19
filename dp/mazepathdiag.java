package dp;

import java.util.Arrays;

public class mazepathdiag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		System.out.println(mp(0, 0, n, n));
		System.out.println(mpt(0, 0, n, n, new int[n + 1][n + 1]));
		System.out.println(mpb(n, n));
		System.out.println(mps(n, n));
	}

	public static int mp(int cc, int cr, int ec, int er) {
		if (cc == ec && cr == er) {
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}

		int h = mp(cc, cr + 1, ec, er);
		int v = mp(cc + 1, cr, ec, er);
		int d = mp(cc + 1, cr + 1, ec, er);

		return h + v + d;
	}

	// dp top down approach
	public static int mpt(int cc, int cr, int ec, int er, int sto[][]) {
		if (cc == ec && cr == er) {
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}
		if (sto[cc][cr] != 0) {
			return sto[cc][cr];
		}
		int h = mpt(cc, cr + 1, ec, er, sto);
		int v = mpt(cc + 1, cr, ec, er, sto);
		int d = mpt(cc + 1, cr + 1, ec, er, sto);

		sto[cc][cr] = h + v + d;
		return h + v + d;
	}

	// dp bottom up approch
	public static int mpb(int s, int e) {
		int sto[][] = new int[s + 2][e + 2];
		for (int i = s; i >= 0; i--) {
			for (int j = e; j >= 0; j--) {
				if (i == s && j == e) {
					sto[i][j] = 1;
				} else {
					sto[i][j] = sto[i][j + 1] + sto[i + 1][j] + sto[i + 1][j + 1];
				}
			}
		}

		return sto[0][0];
	}

	// dp bottom up space optimized
	public static int mps(int s, int e) {
		int[] sto = new int[e + 1];
		Arrays.fill(sto, 1);
		int d = 0;
		for (int i = s - 1; i >= 0; i--) {
			for (int j = e; j >= 0; j--) {
				if (j == e) {
					sto[j] = 1;
					d = 1;
				} else {
					int v = sto[j] + sto[j + 1] + d;
					d = sto[j];
					sto[j] = v;
				}
			}
		}
		return sto[0];
	}
}
