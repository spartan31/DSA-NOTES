package ooPs;

public class Constructor {
    String hello;
    int size;
    
    public Constructor() {
    	System.out.println("Hi constructor is created This will executed just after creating new object of class");
    }
    
    // constructor overloading
    public Constructor(int age) {
    	System.out.println(age*5);
    }
	public String getHello() {
		return hello;
	}
	public void setHello(String hello) {
		this.hello = hello;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	

}
