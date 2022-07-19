package queues;

import java.util.*;

public class Stackbyqueuepop {
	Queue<Integer> p = new LinkedList<>();
	Queue<Integer> s = new LinkedList<>();
	public void push(int data) {
		if (p.size() == 0) {
			p.add(data);
		} else {
			s.add(data);
			while (!p.isEmpty()) {
				int c = p.remove();
				s.add(c);
			}
			while (!s.isEmpty()) {
				int c = s.remove();
				p.add(c);
			}
		}
	}

	public int pop() throws Exception{
	    if(p.isEmpty()) {
	    throw new Exception("Stack is Empty");
	 } 
	    int c  = p.remove();
		return c;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Stackbyqueuepop a = new Stackbyqueuepop();
		a.push(10);
		a.push(12);
		a.pop();
		int c = a.pop();
		System.out.println(c);
		a.pop();
		

	}

}
