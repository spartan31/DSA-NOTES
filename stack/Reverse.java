package stack;

public class Reverse {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		first a = new first(10);
		a.push(10);
		a.push(20);
		a.push(30);
		a.push(40);
		a.push(50);
a.display();
		first help = new first();

		chan(a, help, 0);
		
		a.display();
	}

	public static void chan(first a, first help, int index) throws Exception {
		if(a.isEmpty()) {
			return;
		}
		int item  = a.pop();
		chan(a,help,index+1);
		help.push(item);
		
		if(index == 0) {
			while(!help.isEmpty()) {
				a.push(help.pop());
			}
		}
	}

}
