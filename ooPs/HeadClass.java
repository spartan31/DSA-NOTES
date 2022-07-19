package ooPs;

public class HeadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CLass1 a1 = new CLass1(); 
		a1.name = "ajit";
		a1.roll = 10;
		
		System.out.println(a1.name);
		
		Accesmodifiers a2 = new Accesmodifiers();
		System.out.println(a2.getNaam());
		a2.setA(20);
		System.out.println(a2.getA());
		
		Constructor c1 = new Constructor();
		Constructor c2 = new Constructor(25);
	}

}
