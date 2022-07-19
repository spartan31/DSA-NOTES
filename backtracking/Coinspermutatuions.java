package backtracking;

public class Coinspermutatuions {
 static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ar = { 2, 3, 5 };
		coin(ar, 10, "");
	}

	public static void coin(int[] arr, int amt, String ans) {
		if (amt == 0) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		for (int i = 0 ; i < arr.length; i++) {
			if (amt >= arr[i]) {
				coin(arr, amt - arr[i], ans + arr[i]);
			}
}

	}

}
