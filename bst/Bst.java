package bst;

public class Bst <T>{
	 public T data;
	   public Bst<T> left ;
	   public Bst<T> right ;
	   
	   public Bst(T data){
		   this.data = data;
		   left = null;
		   right = null;
	   }
}
