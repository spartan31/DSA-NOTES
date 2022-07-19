package ooPs;

public class ExceptionClient {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		Exceptionhandling c1 = new Exceptionhandling();
		try {
		c1.setAge(-10);
		} catch(Exception e) {
			System.out.println(" we are in a catch box");
		}
		
		System.out.println("we are out of catch box bye bye everyone");
	}

}
