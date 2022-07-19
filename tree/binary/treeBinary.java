package tree.binary;

public class treeBinary<T>{
   public T data;
   public treeBinary<T> left ;
   public treeBinary<T> right ;
   
   public treeBinary(T data){
	   this.data = data;
	   left = null;
	   right = null;
   }
}
