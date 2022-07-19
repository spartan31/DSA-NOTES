package recurrsion;

public class Searchinglast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,5,13,2,5,6,2,10,13};
		System.out.println(lastval(arr,0,10));
	}
 public static int lastval(int[] arr , int i , int s) {
	 if(i == arr.length) {
		 return 0;
	 }
	 int index = lastval(arr ,i+1 , s);
	 if(index == 0 ) {
		 if(arr[i] == s) {
			 return i;
		 }else {
			 return 0;
		 }
	 }else {
		 return index;
	 }
 }
}
