package stack;

public class Firstclient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		first a = new first(11);
		a.push(10);
		a.push(50);
		a.push(21);
		a.push(51);
		a.push(11);
		a.push(101);
		a.display();

		a.reverse();
		a.display();

		
	}

}
