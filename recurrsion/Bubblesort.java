package recurrsion;

public class Bubblesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,3 ,64,12,01, 45,416,};
		Bubble(arr , 0 , arr.length-1);
		display(arr);

	}
	
	public static void Bubble(int[] arr ,  int a , int b) {
        if ( b == 0) {
			return;
		}
		if(a == b) {
			Bubble(arr , 0 , b-1);
			return;
		}
   
		if(arr[a] > arr[a+1]) {
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
		
		Bubble(arr , a+1 , b);
	}
	
	public static void display(int[] arr ) {
		for(int i = 0 ; i< arr.length; i++ ) {
			System.out.print(arr[i]+" ");
		}
		
	}
	

}
