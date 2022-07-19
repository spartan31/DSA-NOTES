package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class lcomparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if(o1.length() < o2.length()) {
			return -1;
		}else if(o1.length() > o2.length()) {
			return 1 ;
		}
		
		return 0;
	}
	
}
public class stringLengthCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         lcomparator l = new lcomparator();
         PriorityQueue<String> pq = new PriorityQueue<>(l);
         pq.add("Rajpati yadav");
         pq.add("a");
         pq.add("Hello World ");
         pq.add("Suraj");
         pq.add("Aarti");
         pq.add("yadav");
         pq.add("cHINTU");
         pq.add("hari ram yadav");
         pq.add("Pushpa");
         pq.add("cc");
         while(!pq.isEmpty()){
        	 System.out.println(pq.remove());
         }
	}

}
