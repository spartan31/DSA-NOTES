package queues;
import java.util.*;
public class Stackbyqueuepush {
	Queue<Integer> p = new LinkedList<Integer>();
	Queue<Integer> s = new LinkedList<Integer>();
	int d;
	
	public void push(int data) {
		
		p.add(data);
		
	}
	public int pop() throws Exception {
		
		if(!p.isEmpty()) {
			
			while(!(p.size() == 1)) {
				int c = p.remove();
				s.add(c);
			}
			 this.d = p.remove();
			while(!s.isEmpty()) {
				int j = s.remove();
				p.add(j);
			}
			
			
		}
		else  {
			throw new Exception ("Empty string");
		}
		return d;
	}
	
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stackbyqueuepush l = new Stackbyqueuepush();
		
		l.push(10);
		l.push(20);
		l.pop();
		l.pop();
		
		for(int i = 0 ; i < 2 ; i++) {
			System.out.println(l.pop());
		}
	}

}
