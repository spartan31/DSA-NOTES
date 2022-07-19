package linkedist;


public class client {
	public static void main(String[] args) throws Exception { 
		LinkedList ll = new LinkedList();
	    ll.addLast(20);
	    ll.addLast(23);
	    ll.addLast(18);
		ll.addLast(62);
		ll.display();
		ll.addfirst(-1);
		ll.addfirst(9);
		ll.addfirst(-2);
		ll.addfirst(-6);
	    ll.addLast(100);
		ll.display();
		
		System.out.println(ll.returnfirst());
		
		
		System.out.println(ll.returnlast());
		System.out.println(ll.getAt(0));
//		System.out.println(ll.getNodeAt(0));
		ll.addAt(0, 10);
		ll.addAt(3, 11); 
		ll.display();
		ll.reverseData();
		ll.display();
		
	}
}