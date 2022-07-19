package dp;

public class rodcutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
    //    System.out.println(rc(arr,arr.length-1));
 //       System.out.println(rctd(arr,arr.length-1 , new int[arr.length]));
    System.out.println(rcbu(arr));
	}
   public static int rc(int arr[] , int n) {
	   int ans = arr[n] ; 
	   int left = 1 ; 
	   int right = n-1;
	   while(left <= right) {
		   int k = rc(arr,left);
		   int l = rc(arr,right);
		   
		   int total = k + l ;
		   
		   left++;
		   right-- ;
		  if(total > ans) {
			  ans  = total ;
		  } 
		  
	   }
      return ans ;   
   }
   
   // top down approch
   public static int rctd(int arr[] , int n,int sto[]) {
	   if(sto[n] != 0)  return sto[n] ;
	   int ans = arr[n] ; 
	   int left = 1 ; 
	   int right = n-1;
	   while(left <= right) {
		   int k = rctd(arr,left,sto);
		   int l = rctd(arr,right,sto);
		   
		   int total = k + l ;
		   
		   left++;
		   right-- ;
		  if(total > ans) {
			  ans  = total ;
		  } 
		  
	   }
	   sto[n] = ans ;
      return ans ;   
   }
   
   // bottom up approach dp 
   public static int rcbu(int arr[]) {
	   int sto[] =  new int[arr.length] ;
	   sto[0] =arr[0] ;
	   sto[1] = arr[1] ;
	   
	   for(int n = 2 ; n < sto.length ; n++) {
		   int ans = arr[n] ;  
		   int left = 1 ; 
		   int right = n-1;
		   while(left <= right) {
			   int k = sto[left];
			   int l = sto[right];
			   
			   int total = k + l ;
			   
			   left++;
			   right-- ;
			  if(total > ans) {
				  ans  = total ;
			  } 
			  
		   }
		   sto[n] = ans ;
	   }
	   
	   for(int p = 0 ; p < sto.length ; p++) {
		   System.out.print(sto[p] + " ");
	   }
	   System.out.println();
	   return sto[sto.length-1] ;
   }
}
