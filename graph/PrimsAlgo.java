package graph;
import java.util.*;
public class PrimsAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	void prim(ArrayList<ArrayList<Nodee>> adj , int n) {
		int key[] = new int[n] ;
		int parent[] = new int[n];
		boolean mst[] = new boolean[n];
		
		Arrays.fill(mst, false);
		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		key[0] = 0 ;
		PriorityQueue<Nodee> pq = new PriorityQueue<>() ;
		pq.add(new Nodee(0,key[0]));
		for(int i = 0 ; i  < n -1 ; i++){
			int u = pq.poll().getV();
			
			mst[u] = true ;
			for(Nodee it : adj.get(u)){
				if(mst[it.getV()] == false && it.getW() < key[it.getV()]){
					parent[it.getV()] = u;
					key[it.getV()] = it.getW() ;
					pq.add(new Nodee(it.getV(),key[it.getV()]));
				}
			}
		}
		
		for(int i =0 ; i < n ; i++) {
			System.out.println(parent[i] + " - " + i);
		}
	}

}

class Nodee implements Comparator<Nodee>{
	private int v ;
	private int w ;
	
	Nodee( int v , int w ){
		this.v = v ;
		this.w = w ;
	}
	
	int getV() {
		return v;
	}
	
	int getW() {
		return w ;
	}

	@Override
	public int compare(Nodee o1, Nodee o2) {
		if(o1.w < o2.w) return -1 ;
		if(o1.w < o2.w) return 1 ;
		return 0;
	}
}
