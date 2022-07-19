package queues;
import java.util.*;
public class Priorityque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> p = new PriorityQueue<>();
		p.add("Apple");
		p.add("Kaka");
		p.add("Hello");
		p.add("Nikle");
		System.out.println(p);
		System.out.println(p.remove());
		System.out.println(p.remove());
		System.out.println(p.remove());
		System.out.println(p.remove());  
		
		
		
		

	}

}
