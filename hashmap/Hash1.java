package hashmap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Hash1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      HashMap<String , Integer> map = new HashMap<>();
     map.put("USA", 200);
     map.put("UK", 175);
     map.put("India", 300);
	 map.put("Japan", 150);
	 System.out.println(map);
	 
	 System.out.println(map.containsKey("India"));
	 map.remove("Japan");
	 System.out.println(map.containsValue(150));
	 Set<String> keys = map.keySet();
     System.out.println("*******KEYS*******");
	 for(String key : keys) {
		 System.out.println(key);
	 }
	Collection<Integer> values = map.values();
    System.out.println("*******values*******");
	for(Integer val : values) {
		System.out.println(val);
	}
	Set<Map.Entry<String ,Integer>> entries  = map.entrySet();	
    System.out.println("******WITH ALL ENTRIES*******");
    for(Map.Entry<String, Integer> entry : entries) {
    	System.out.println(entry.getKey() + " => "+ entry.getValue());
    }
  }
}
