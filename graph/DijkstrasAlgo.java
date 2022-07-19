package graph;

import java.util.*;
class Nod implements Comparator<Nod>{
	private int v ;
	private int w ;
	
	Nod( int v , int w ){
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
	public int compare(Nod o1, Nod o2) {
		if(o1.w < o2.w) return -1 ;
		if(o1.w > o2.w) return 1 ;
		return 0;
	}
}

public class DijkstrasAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	void sp(int  s ,ArrayList<ArrayList<Nod>> gr, int n) {
		int dist[] = new int[n] ;
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0 ;
		
		PriorityQueue<Nod> pq = new PriorityQueue<Nod>();
		pq.add(new Nod(s,0));
		
		while(!pq.isEmpty()) {
			Nod nn = pq.poll() ;
			
			for(Nod it : gr.get(nn.getV())) {
				if(dist[nn.getV()] + it.getW() < dist[it.getV()]){
					dist[it.getV()] = dist[nn.getV()] + it.getW() ;
					pq.add(new Nod(it.getV() , it.getW())) ;
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println(dist[i] + " ");
		}
	}

}

