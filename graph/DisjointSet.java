package graph;

public class DisjointSet {
	static int par[]  = new int[1000000];
	static int rank[]  = new int[1000000];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       makeSet(6);
	}
	public static void makeSet(int n) {
		for(int i = 1 ; i <= n ; i++ ) {
			par[i] = i ;
			rank[i] = 0 ;
		}
	}
	
	public static int findPar(int node) {
		if(node == par[node]) {
			return node;
		}
		return par[node] = findPar(par[node]);
	}
	
	public static void union(int u, int v) {
		u = findPar(u);
		v = findPar(v);
		
		if(rank[u]<rank[v]) {
			par[u] = v ;
		}else if(rank[u] > rank[v]) {
			par[v] = u ;
		}else {
			par[u] = v ;
			rank[v]++ ;
		}
	}

}
