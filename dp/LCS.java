package dp;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "ABCDGH" ;
		String b = "ACDGHR" ;
         System.out.println(lcs(a,b));
         System.out.println(lcso(a,b,0,0));
         System.out.println(lcstd(a,b,0,0,new int[a.length()][b.length()]));
         System.out.println(lcsbu(a,b));
	}
    
	public static int lcs(String s1 , String s2) {
		if(s1.length() == 0 || s2.length() == 0) {
			return 0 ;
		}
		char c1 = s1.charAt(0);
		char c2 = s2.charAt(0);
		String ros = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans = 0 ;
		if(c1 == c2) {
			ans = lcs(ros,ros2) +1;
		}else {
			int o1 = lcs(s1,ros2);
			int o2 = lcs(ros,s2);
			ans = Math.max(o1, o2);
		}
		
		return ans;
	}
	
	// optimsed recuur by removing substring function
	public static int lcso(String s1 , String s2, int idx1 , int idx2) {
		if(s1.length() == idx1 || s2.length() == idx2) {
			return 0 ;
		}
		char c1 = s1.charAt(idx1);
		char c2 = s2.charAt(idx2);
		int ans = 0 ;
		if(c1 == c2) {
			ans = lcso(s1,s2,idx1 + 1 , idx2 + 1) +1;
		}else {
			int o1 = lcso(s1,s2,idx1,idx2 + 1);
			int o2 = lcso(s1,s2 , idx1 + 1 , idx2);
			ans = Math.max(o1, o2);
		}
		
		return ans;
	}	
	
	// dp bottom up approach 
	public static int lcstd(String s1 , String s2, int idx1 , int idx2,int[][] s) {
		if(s1.length() == idx1 || s2.length() == idx2) {
			return 0 ;
		}
		char c1 = s1.charAt(idx1);
		char c2 = s2.charAt(idx2);
		int ans = 0 ;
		if(s[idx1][idx2] != 0){
			return s[idx1][idx2];
		}
		if(c1 == c2) {
			ans = lcstd(s1,s2,idx1 + 1 , idx2 + 1,s) +1;
		}else {
			int o1 = lcstd(s1,s2,idx1,idx2 + 1,s);
			int o2 = lcstd(s1,s2 , idx1 + 1 , idx2,s);
			ans = Math.max(o1, o2);
		}
		
		s[idx1][idx2] = ans;
		return ans;
	}
	// dp bottom up approch
	public static int lcsbu(String a , String b ) {
		int[][] arr = new int[a.length()+1][b.length()+1];
		for(int i = a.length()-1 ; i >= 0 ; i--) {
			for(int j = b.length()-1 ; j >= 0 ; j--) {
				if(a.charAt(i) == b.charAt(j)) {
					arr[i][j] = arr[i+1][j+1] +1 ;
				}else {
					int o1 = arr[i][j+1] ;
					int o2 = arr[i+1][j] ;
					arr[i][j] = Math.max(o1, o2);
				}
			}
		}
		
		return arr[0][0] ;
	}
}
