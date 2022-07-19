package bst;

public class LinkList {

	private class Node {
		int Data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(" " + temp.Data);
			temp = temp.next;
		}
		System.out.println();
	}

	public void addLast(int data) {
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

	public void addfirst(int data) {
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

	public int returnfirst() throws Exception {
		if (this.size == 0) {
			throw new Exception(" LinkList is Empty");
		}

		return this.head.Data;
	}
	public int returnlast() throws Exception {
		if (this.size == 0) {
			throw new Exception(" LinkList is Empty");
		}

		return this.tail.Data;
	}
	
	public int getAt(int index)  throws Exception {
		if (this.size == 0) {
			throw new Exception(" LinkList is Empty");
		}
		if(index >= this.size || index < 0) {
			throw new Exception (" Index input out of Bound ");
		}
		
		Node temp = this.head;
		for(int i = 1 ; i <= index; i++) {
			temp = temp.next;
		}
		return temp.Data;
	}
	
	private Node getNodeAt(int index)  throws Exception {

		if (this.size == 0) {
			throw new Exception(" LinkList is Empty");
		}
		if(index >= this.size || index < 0) {
			throw new Exception (" Index input out of Bound ");
		}
		
		Node temp = this.head;
		for(int i = 1 ; i <= index; i++) {
			temp = temp.next;
		}
		return temp;
	}
    public void addAt(int index , int data) throws Exception{
    	if(index <0 || index > size) {
    		throw new Exception (" invalid Index");
    	}
    	
    	if(index == 0) {
    		addfirst(data);
    	} else if(index == this.size ) {
    		addLast(data);
    	}else {
    		Node nn = new Node();
    		nn.Data = data;
    		nn.next = null;
    		
    		
    		Node nm1 = getNodeAt(index-1);
    		Node nm = nm1.next;
    		
    		nm1.next = nn;
    		nn.next = nm;
    		
    		this.size++;
    		
    	}
    	
    	}
    public int removeFirst() throws Exception {
    	if(this.size == 0) {
    		throw new Exception("List is Empty");
    	}
    	int rv = this.head.Data;
    	if(this.size == 1) {
    		this.head = null;
    		this.tail = null;
    		this.size = 0;
    	}else {
    		this.head = this.head.next;
    		this.size--;
    	}
    	return rv;
    }
    
    public int removeLast() throws Exception {
    	if(this.size == 0) {
    		throw new Exception("List is Empty");
    	}
    	int rv = this.tail.Data;
    	if(this.size == 1) {
    		this.head = null;
    		this.tail = null;
    		this.size = 0;
    	}else {
    		Node sm2= getNodeAt(this.size-2);
    		this.tail = sm2;
    		this.tail.next = null;
    		this.size--;
    	}
    	return rv;
    }

    public int removeAt(int index) throws Exception{
    	if(this.size == 0) {
    		throw new Exception("List is Empty");
    	}
    	if(index <0 || this.size  <= index) {
    		throw new Exception("Invalid Index");
    	}
    	
    	if(index == 0) {
    		return removeFirst();
    	}else if(index == this.size-1) {
    		return removeLast();
    	}else {
    	   Node nm1 = getNodeAt(index-1);
    	   Node  n = nm1.next;
    	   Node np1 = n.next;
    	   
    	   nm1.next = np1;
    	   this.size--;
    	   return n.Data;
    	}
    	}

  public void reverseData() throws Exception {
	  int  left = 0 ;
	  int right = this.size-1;
	  
	  while(left<right) {
		  Node ln = getNodeAt(left);
		  Node rn = getNodeAt(right);
		  
		  int temp = ln.Data;
		  ln.Data = rn.Data;
		  rn.Data = temp;
		  
		  left++;
		  right--;
	}
	  
  }
 
}
