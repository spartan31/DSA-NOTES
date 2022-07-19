package ooPs;

public class InheritanceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       InheritanceP p1 = new InheritanceP();
       
       System.out.println(p1.d);
       p1.fun();
       InheritanceC c1 = new InheritanceC();
       System.out.println(c1.d1);
       c1.fun1();
       
       
       System.out.println("case -----1");
       InheritanceP p2 = new InheritanceP();
       System.out.println(p2.d1);
       System.out.println(p2.d);
       p2.fun1();
       
       System.out.println("case -----2");
       InheritanceP p3 = new InheritanceC();
       System.out.println(((InheritanceC)p3).d2);
       System.out.println(p2.d);
       p3.fun1();
       ((InheritanceC)p3).fun3();
       
       System.out.println("case -----3");
//       InheritanceC c2 = new InheritanceP();    **** This is not possible in java gives runtime error ****
       System.out.println(p2.d1);
       p2.fun1();
       
       
       
       System.out.println("case -----4");
       InheritanceC	 c3 = new InheritanceC();
       System.out.println(c3.d);
       System.out.println(((InheritanceC)c3).d);
       System.out.println(c3.d1);
       System.out.println(c3.d2);
       c3.fun1();
       c3.fun3();
       
	}

}
