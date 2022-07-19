package hashmap;
import java.util.*;
public class MaxFrequency {

	public static void main(String[] args) {
	   String str = "ccdd" ; 
        System.out.println(max(str));
	}
    public static char max(String str ) {
    	HashMap<Character, Integer> map = new HashMap<>();
    	for(int i = 0 ; i < str.length() ; i++) {
    		char  cc = str.charAt(i);
    		if(map.containsKey(cc)) {
    			int v = map.get(cc);
    			map.put(cc, v+1);
    		}else {
    		map.put(cc,1);	
    		}
    	}
       char maxchar = '\0';
       int max= 0;
       Set<Map.Entry<Character, Integer>> entries = map.entrySet();
       for(Map.Entry<Character, Integer> entry : entries) {
    	   if(entry.getValue() >max) {
    		   max = entry.getValue();
    		   maxchar = entry.getKey();
    	   }
       }
       return maxchar;
    }
}
