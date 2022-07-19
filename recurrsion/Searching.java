package recurrsion;

public class Searching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] arr = {10,5,4,2,5,6,2,1,13};
      System.out.println(search(arr,0,13));
	}
	
	public static int search(int[] arr , int i , int s) {
	if (i == arr.length) {
		return -1;
	}
	if(s == arr[i]) {
		return i;
	}else {
		int next = search(arr , i+1 , s);
		return next;
	}
	
}
}
