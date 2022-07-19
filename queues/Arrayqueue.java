package queues;

public class Arrayqueue {
	
	private int arr[] ;
    private int front; 
	private int rear;
	private int size;
	
	public static int default_capacity = 4;
	
	public Arrayqueue(){
		this(default_capacity);
	}

	public Arrayqueue(int capacity) {
		// TODO Auto-generated constructor stub
		this.arr = new int[capacity];
		this.front = 0;
		this.rear = 0;
		this.size = 0;
	}
	
	public void enqueue(int data) {
		this.arr[rear] = data;
		this.size++;
		this.rear++;
	}
	
	public void display() {
		for(int i = 0; i< size;i++) {
			System.out.println(this.arr[this.front+i]);
		}
	}
	public int dequeue() {
		
		int rv = this.arr[front];
		this.front++;
		this.size--;
		return rv;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrayqueue a = new Arrayqueue(10);
		a.enqueue(10);
		a.enqueue(20);
		a.enqueue(21);
		a.enqueue(16);
		a.enqueue(50);
		a.enqueue(555);
		a.dequeue();
		a.dequeue();
		a.display();
		

	}

}
