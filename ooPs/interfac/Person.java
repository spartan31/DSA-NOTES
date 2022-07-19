package ooPs.interfac;

public class Person implements Student,Youtube{
	
 @Override
 public  void study() {
		System.out.println("Student is running");
	}
 
 public  void make() {
		System.out.println("Youtuber is making videos");
	}
}
