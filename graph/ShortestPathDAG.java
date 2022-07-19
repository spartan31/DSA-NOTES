package graph;

import java.util.*;

public class ShortestPathDAG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void sp(int s , ArrayList<ArrayList<Pair>> adj , int n ) {
		Stack<Integer> st = new Stack<>() ;
		int dist[] = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0 ;
		Boolean vis[] = new Boolean[n] ;
		Arrays.fill(vis, false);
		
		for(int i1 = 0 ; i1 < n ; i1++) {
			if(vis[i1] == false) {
				toposort(i1,vis,st,adj);
			}
		}
		
		while(!st.isEmpty()) {
			int node  = st.pop() ;
			
			if(dist[node] != Integer.MAX_VALUE) {
				for(Pair it : adj.get(node)) {
					if(dist[node] + it.getW() < dist[it.getW()]) {
						dist[it.getW()] = dist[node] + it.getW() ;
					}
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			if(dist[i] == Integer.MAX_VALUE){
				System.out.print("Infinity Unreachable  ");
			}else {
				System.out.print(dist[i] + " ");
			}
			
		}
		
	}

	private static void toposort(int node, Boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj) {
		vis[node] = true;
		for(Pair it : adj.get(node)) {
			if(!vis[it.getV()]) {
				toposort(it.getV(),vis,st,adj);
			}
		}
		
		st.push(node);
		
	}

}
class Pair{
	private int v ;
	private int w ;
	
	Pair( int v , int w ){
		this.v = v ;
		this.w = w ;
	}
	
	int getV() {
		return v;
	}
	
	int getW() {
		return w ;
	}
}
