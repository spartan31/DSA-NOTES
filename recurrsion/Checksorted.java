package recurrsion;

public class Checksorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {11 , 11, 12, 13 , 13 };
        System.out.println(sorted(arr,0)); 
	}
  public static boolean sorted(int[] arr, int i) {
	  if(i == arr.length-1) {
		  return true;
	  }
	  
	if(arr[i] > arr[i+1]) {
		return false;
	}else {
		
		boolean check = sorted(arr, i+1);
		return check;
	}
	  
  }
}
