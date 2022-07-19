  package ooPs;

public class Studentcall {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Student[] arr = new Student[1000];
		for(int i = 0 ; i < 1000 ; i++) {
			arr[i] = new Student(i+"th");
			System.out.println(Student.Getnostudents()+ " " + arr[i].getName()+" Roll no =  "+ arr[i].No);
	}
System.out.println(Student.Maxno);

Student.staticfunc();
arr[261].nonstatic();
arr[236].setcolor("Red");
System.out.println(arr[236].getcolor());
System.out.println(arr[238].getcolor());
}
}