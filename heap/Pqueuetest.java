package heap;

public class Pqueuetest {

	public static void main(String[] args) throws PriorityQException {
		// TODO Auto-generated method stub
        P_Queue  p = new P_Queue();
        int arr[] = {0 , 221 , 9 , 23};
        for(int i = 0 ; i < arr.length ; i++) {
        	p.insert(arr[i]);
        }
        while(!p.isEmpty()) {
        	System.out.print(p.remove()+" ");
        }
        
	}   

}
