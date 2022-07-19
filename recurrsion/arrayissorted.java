package recurrsion;

public class arrayissorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3,6};
        System.out.println(sort(arr,0));
	
	}
	public static boolean sort(int arr[] , int s) {
		if(s == arr.length) {
			return true;
		}
		if (arr[s] > arr[s+1]) 
		{
			return false ;
		}else {
			boolean rest = sort(arr,s+1);
			return rest;
		}
		
	}

}
