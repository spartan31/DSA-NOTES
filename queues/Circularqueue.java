package queues;

public class Circularqueue {

	private int arr[];
	private int cs;
	private int ms;
	private int front;
	private int rear;

	public static int default_capacity = 20;

	Circularqueue() {
		this(default_capacity);
	}

	public Circularqueue(int capacity) {
		// TODO Auto-generated constructor stub

		this.arr = new int[capacity];
		this.cs = 0;
		this.ms = capacity;
		this.front = 0;
		this.rear = capacity - 1;
	}

	public boolean isfull() {
		return this.cs == this.ms;
	}

	public boolean isempty() {
		return this.cs == 0;
	}

	public void enqueue(int data) {
		if (!isfull()) {
			this.rear = (this.rear + 1) % this.arr.length;
			this.arr[this.rear] = data;
			this.cs = this.cs + 1;

		}
	}

	public void dequeue() {
		if (!isempty()) {
			this.front = (this.front + 1) % this.arr.length;
			this.cs = this.cs - 1;
		}
	}

	public int getfront() {
		return this.arr[this.front];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circularqueue c= new Circularqueue(4);
		c.enqueue(10);
		c.enqueue(20);
		c.enqueue(50);
		c.enqueue(41);
		c.enqueue(26);
		
	c.dequeue();
		c.dequeue();
		c.enqueue(23);
		while(!c.isempty()) {
			System.out.print(c.getfront()+" ");
			c.dequeue();
		}
		//
		while(!c.isempty()) {
			System.out.println(c.getfront());
			c.dequeue();
		}

	}
}
