package dp;

import java.util.Arrays;

public class Colormixture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 40, 60, 20, 50 };
		System.out.println(mr(arr, 0, arr.length - 1));
		int sto[][] = new int[arr.length + 1][arr.length + 1];
		for (int i = 0; i < sto.length; i++) {
			Arrays.fill(sto[i], -1);
		}

		System.out.println(mtd(arr, 0, arr.length - 1, sto));
		System.out.println(mbu(arr));
	}

	public static int mr(int arr[], int s, int e) {
		if (s == e)
			return 0;
		int ans = Integer.MAX_VALUE;
		for (int k = s; k <= e - 1; k++) {
			int a = mr(arr, s, k);
			int b = mr(arr, k + 1, e);
			int colour = csum(arr, s, k) * csum(arr, k + 1, e);
			int total = a + b + colour;
			if (total < ans) {
				ans = total;
			}
		}

		return ans;
	}

	public static int csum(int arr[], int s, int e) {
		int sum = 0;
		for (int i = s; i <= e; i++) {
			sum += arr[i];
		}
		return sum % 100;
	}

	/// toop down dp approch
	public static int mtd(int arr[], int s, int e, int sto[][]) {
		if (s == e)
			return 0;
		int ans = Integer.MAX_VALUE;
		if (sto[s][e] != -1)
			return sto[s][e];
		for (int k = s; k <= e - 1; k++) {
			int a = mtd(arr, s, k, sto);
			int b = mtd(arr, k + 1, e, sto);
			int colour = csum(arr, s, k) * csum(arr, k + 1, e);
			int total = a + b + colour;
			if (total < ans) {
				ans = total;
			}
		}
		sto[s][e] = ans;
		return ans;
	}

	public static int mbu(int arr[]) {
		int n = arr.length;
		int sto[][] = new int[n][n];
		for (int slide = 0; slide <= n-1; slide++) {
			for (int s = 0; s <= n - slide - 1; s++) {
				int e = s + slide;
				if (s == e) {
					sto[s][e] = 0;
				} else {
					int ans = Integer.MAX_VALUE;    
					for (int k = s; k <= e - 1; k++) {
						int a = sto[s][k];
						int b = sto[k + 1][e];
						int colour = csum(arr, s, k) * csum(arr, k + 1, e);
						int total = a + b + colour;
						if (total < ans) {
							ans = total;
						}
					}
					sto[s][e] = ans ;
				}
			}

		}
		return sto[0][n-1];
	}

}
