package ooPs;

public class Student {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if (name.equals("") || name.equals(null)) {
			throw new Exception("String can't be empty");
		}

		this.name = name;
	}

	public final int No;
	private static int Numberofstudents;

	public static int Getnostudents() {
		return Student.Numberofstudents;
	}

	private static String uniformcolor = "White";

	public static String getcolor() {
		return Student.uniformcolor;
	}

	public static void setcolor(String uniformcolor) {
		Student.uniformcolor = uniformcolor;
	}

	public static final int Maxno = 1000;

	public Student(String name) throws Exception {
		if (Student.Numberofstudents == Student.Maxno) {
			throw new Exception("Mx limmit exceeds");
		}

		this.setName(name);
		Student.Numberofstudents++;
		this.No = Student.Numberofstudents;

	}

	public void nonstatic() {
		System.out.println(this.name + "says hello to" + Student.Numberofstudents);
	}
	public static void staticfunc() {
		System.out.println(Student.Numberofstudents + " out of possible " + Student.Maxno); 
	}
}
