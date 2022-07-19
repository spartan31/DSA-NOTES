package recurrsion;

public class Allindeces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr  = { 1, 10, 1, 5, 1, 8, 10, 1};
		int[] base = all(arr,0,10,0);
		for(int i = 0 ; i< base.length;i++) {
			System.out.print(base[i] + " " );
		}

	}
  public static int[] all(int[] arr , int i , int e , int c) {
	  if(i == arr.length) {
		  int base[] = new int[c];
		  return base;
	  }
	  int[] index = null;
	  if(arr[i] == e) {
		  index = all(arr , i+1 , e , c+1);
	  }else {
		  index = all(arr , i+1 , e ,c);
	  }
	  
	if(arr[i] == e) {
		  index[c] = i;
	  }
	  return index;
  }
  
}
