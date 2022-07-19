package interfaceandGenerics;

import java.util.Comparator;

public class genric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {10 , 20 ,1};
		String a[] = {"Delhi " , "pak" , "aus"};
         
         
         car c[] = new car[5];
         c[0] = new car(80 , 5 , "Red");
         c[1] = new car(60 , 4 , "Blue");
         c[2] = new car(90 , 6 , "Pink");
         c[3] = new car(70 , 8 , "Yellow");
         c[4] = new car(30 , 2 , "White");
         sortb(c,new carspeedcomparator());
         display(c);
         System.out.println();
         System.out.println();
         sortb(c , new carpowercomparator());
         display(c);
                  
	}
    
/*	public void dislplay(Integer arr[]) {
		for(Integer a : arr) {
			System.out.println(a + " ");
		}
	}
	
	public void dislplay(String arr[]) {
		for(String a : arr) {
			System.out.println(a + " ");
		}
	}  */
	
	public static <G> void  display(G arr[]) {
		for(G a : arr) {
			System.out.println(a + " ");
		}
	}
	
	public static <T> void sortb(T arr[] , Comparator<T> comp) {
		for(int i = 0 ; i < arr.length - 1 ; i++) {
			for(int j = 0 ; j < arr.length - 1 ; j++) {
				if(comp.compare(arr[j], arr[j+1]) > 0) {
				    T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
