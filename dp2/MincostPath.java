package dp2;

public class MincostPath {

	 public static int min(int arr[][]) {
		 return minP(arr,0,0);
	 }
	 
	private static int minP(int[][] arr, int i, int j) {
		int m = arr.length;
		int n = arr[0].length;
		if(i == m-1 && j == n-1) {
			return arr[i][j];
		}
		
		if(i>=m || j>=m)  return Integer.MAX_VALUE ;
		
		
		int a = minP(arr,i,j+1);
		int b = minP(arr,i+1,j+1);
		int c = minP(arr,i+1,j);
		
		return arr[i][j] + Math.min(a,Math.min(b,c));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[][] = {{1,1,1} ,{4,5,2} ,{7,8,9}};
      System.out.println(min(arr));
	}

}
