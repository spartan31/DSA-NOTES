package hasmapimplement;


public class LinkedList<T> {

	private class Node {
		T Data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;
    
	
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(" " + temp.Data);
			temp = temp.next;
		}
		System.out.println();
	}

	public void addLast(T data) {
		Node nn = new Node();
		nn.Data = data;
		nn.next = null;

		if (this.size >= 1) {
			this.tail.next = nn;
		}
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}

	public void addfirst(T data) {
		Node nn = new Node();
		nn.Data = data;
		nn.next = null;
		if (this.size >= 1) {
			nn.next = head;
		}

		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}
	}

	public T returnfirst() throws Exception {
		if (this.size == 0) {
			throw new Exception(" LinkedList is Empty");
		}

		return this.head.Data;
	}

	public T returnlast() throws Exception {
		if (this.size == 0) {
			throw new Exception(" LinkedList is Empty");
		}

		return this.tail.Data;
	}

	public T getAt(int index) throws Exception {
		if (this.size == 0) {
			throw new Exception(" LinkedList is Empty");
		}
		if (index >= this.size || index < 0) {
			throw new Exception(" Index input out of Bound ");
		}

		Node temp = this.head;
		for (int i = 1; i <= index; i++) {
			temp = temp.next;
		}
		return temp.Data;
	}

	private Node getNodeAt(int index) throws Exception {

		if (this.size == 0) {
			throw new Exception(" LinkedList is Empty");
		}
		if (index >= this.size || index < 0) {
			throw new Exception(" Index input out of Bound ");
		}

		Node temp = this.head;
		for (int i = 1; i <= index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void addAt(int index, T data) throws Exception {
		if (index < 0 || index > size) {
			throw new Exception(" invalid Index");
		}

		if (index == 0) {
			addfirst(data);
		} else if (index == this.size) {
			addLast(data);
		} else {
			Node nn = new Node();
			nn.Data = data;
			nn.next = null;

			Node nm1 = getNodeAt(index - 1);
			Node nm = nm1.next;

			nm1.next = nn;
			nn.next = nm;

			this.size++;

		}

	}

	public T removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is Empty");
		}
		T rv = this.head.Data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}
		return rv;
	}

	public T removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is Empty");
		}
		T rv = this.tail.Data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node sm2 = getNodeAt(this.size - 2);
			this.tail = sm2;
			this.tail.next = null;
			this.size--;
		}
		return rv;
	}

	public T removeAt(int index) throws Exception {
		if (this.size == 0) {
			throw new Exception("List is Empty");
		}
		if (index < 0 || this.size <= index) {
			throw new Exception("Invalid Index");
		}

		if (index == 0) {
			return removeFirst();
		} else if (index == this.size - 1) {
			return removeLast();
		} else {
			Node nm1 = getNodeAt(index - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;
			return n.Data;
		}
	}
	
	  public int find(T data) {
	    	int index = 0;
	    	for(Node temp = this.head ; temp != null ; temp = temp.next) {
	    		if(temp.Data.equals(data)) {
	    			return index ;
	    		}
	    		index++;
	    	}
	    	
	    	return -1 ;
	    }

	public void reverseData() throws Exception {
		int left = 0;
		int right = this.size - 1;

		while (left < right) {
			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			T temp = ln.Data;
			ln.Data = rn.Data;
			rn.Data = temp;

			left++;
			right--;
		}

	}

}
