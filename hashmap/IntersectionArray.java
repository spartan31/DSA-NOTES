package hashmap;
import java.util.*;
public class IntersectionArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[]  = { 10 , 15   , 6 , 8 , 9};
      int arr2[] = { 8 , 6 , 14 , 10 , 16 , 19 , 1 , 2 , 3};
   //   ArrayList<Integer> ans= inter(arr,arr2);
	//   System.out.println(ans);
	   
	   
	   String str = "hello";
	   System.out.println(nonrepeatingCharacter(str));
	}
   public static ArrayList<Integer> inter(int [] o , int [] t){
	    HashMap<Integer,Boolean > map =new HashMap<>();
	    ArrayList<Integer> ans = new ArrayList<>();
	    for(int i = 0 ; i < o.length ; i++) {
	    	map.put(o[i], false);
	    }
	   
	    for(int i = 0 ; i < t.length ; i++) {
	    	if(map.containsKey(t[i])) {
	    	map.put(t[i], true);
	    	}
	    }
   Set<Map.Entry<Integer,Boolean>> entries = map.entrySet();
   for(Map.Entry<Integer, Boolean> entry : entries) {
	   if(entry.getValue()) {
		   ans.add(entry.getKey());
	   }
   }
   
   return ans;
   }
   
   
   static char nonrepeatingCharacter(String str)
   {
       HashMap<Character,Boolean> map = new HashMap<>();
       int index = str.length()+1;
       for(int i = 0 ; i < str.length() ; i++) {
   		char  cc = str.charAt(i);
   		if(map.containsKey(cc)) {
   			map.put(cc, true);
   		}else {
   		map.put(cc,false);	
   		}
   	}
        Set<Map.Entry<Character, Boolean>> entries = map.entrySet();
        for(Map.Entry<Character, Boolean> entry : entries) {
   	   if(entry.getValue() == false) {
   		   char a = entry.getKey();
   		   int idx = str.indexOf('a');
   		   if(index>idx){
   		       index = idx;
   		   }
   	   }
      }
      
      if(index >= str.length()){
          return '$' ;
      }else{
          return str.charAt(index);
      }
   }
}
