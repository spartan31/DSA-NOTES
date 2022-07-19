package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class MaxComparator implements  Comparator<Integer>{

	@Override
	public int compare(Integer o, Integer o1) {
		// TODO Auto-generated method stub
		if(o < o1) {
			return 1 ;
		}else if(o > o1){
			return -1;
		}
		
		return 0;
	}
	
}

public class MaxPQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  MaxComparator m = new MaxComparator();
       PriorityQueue<Integer> pq = new PriorityQueue<>(m);
       pq.add(10);
       pq.add(5);
       pq.add(45);
       pq.add(7);
       
       while(!pq.isEmpty()) {
    	   System.out.println(pq.remove());
       }
	}

}
