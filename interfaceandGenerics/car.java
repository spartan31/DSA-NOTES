package interfaceandGenerics;

public class car implements Comparable <car>{
	int speed;
	String color;
	int power;
    
	public  car(int speed , int power , String color) {
		this.color = color;
		this.power = power;
		this.speed = speed;
	}
	public int compareTo(car c) {
		
		return this.color.compareTo(c.color) ;
	}
   public String toString() {
	   return "S : " + this.speed + " P : " + this.power + " C : " + this.color ;
   }
   
}
