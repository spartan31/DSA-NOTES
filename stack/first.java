package stack;

public class first {
   protected int[] data; 
   protected int top;
   
   public static final int default_capacity = 10;
   
   public  first() throws Exception{
	   this(default_capacity);
  }
   
   public first(int capacity) throws Exception{
	   if(capacity <1) {
		   throw new Exception("invalid Capacity"); 
	   }
	   this.data = new int[capacity];
	   this.top = -1 ;
     }
   public  int size() {
	   return this.top+1;
   }
   
   public boolean isEmpty() {
	   return this.size() == 0;
   }
    
   public void  push(int value) throws Exception{
	   if(this.size() == this.data.length) {
		   throw new Exception("Stack is full");
	   }
	   this.top++;
	   this.data[this.top] = value;
   }
   
   public int pop() throws Exception{
	   if(this.size() == 0) {
		   throw new Exception("Stack is Empty");
	   }
	   
	   int rv  = this.data[this.top];
	   this.data[this.top] = 0;
	   this.top--;
	   return rv;
   }
   
   public int topest () throws Exception{
	   if(this.size() == 0) {
		   throw new Exception("Stack is Empty");
	   }
	   
	   int rv  = this.data[this.top];
	   return rv;
   }
   
   public void display() {
	   for(int i = this.top; i >=0 ; i--) {
		   System.out.print(this.data[i]+ ", ");
	   }
	   System.out.println("the end");
   }
   public void reverse() {
	   for(int i  = this.top; i >=0 ; i--) {
		   for (int j = 0 ; j <= this.top; j++) {
//			   if(i == j) {
//				   return;
//			   }else {
			   int temp = 0;
			    temp = this.data[i];
			   this.data[i] = this.data[j];
			   this.data[j] = temp;
//		   }
			   }
	   }
   }
}

