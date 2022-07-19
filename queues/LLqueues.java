package queues;

import java.util.*;

public class LLqueues {
	LinkedList<Integer> q;
	
	LLqueues(){
		q = new LinkedList<>();
	}
	
	public boolean isempty() {
		return q.isEmpty();
	}
	
	public void enqueue(int data) {
		q.addLast(data);
		
	}
	
	public void dequeue() {
		q.removeFirst();
	
	}
	
	public int getfront() {
		return q.getFirst();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LLqueues a = new LLqueues();
		for(int i = 0; i < 6 ; i++) {
			a.enqueue(i*10);
		}
		
		a.dequeue();
		a.dequeue();
		a.enqueue(555);
		a.enqueue(0);
		System.out.print(a);
		while(!a.isempty()) {
			System.out.println(a.getfront());
			a.dequeue();
		}

	}

}
