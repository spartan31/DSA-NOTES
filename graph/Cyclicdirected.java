package graph;

import java.util.*;

public class Cyclicdirected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isCyclic(ArrayList<ArrayList<Integer>> gr , int V) {
		int vis[] = new int[V+1] ;
		int dfsvis[] = new int[V+1];
		
		for(int i  = 1 ; i <= V ;i++ ) {
			if(vis[i] == 0) {
				if(dfs(i,vis,dfsvis,gr)) return true ;
			}
		}
		return false;
	
	}

	private static boolean dfs(int i, int[] vis, int[] dfsvis, ArrayList<ArrayList<Integer>> gr) {
		// TODO Auto-generated method stub
		vis[i] = 1 ;
		dfsvis[i] = 1 ;
		for(int j : gr.get(i)) {
			if(vis[j] == 0) {
				if(dfs(j,vis,dfsvis,gr))  return true ;
			}else if(dfsvis[j]==1) {
				return true ;
			}
		}
		
		dfsvis[i] = 0 ;
		return false;
	}
	
	
	private static boolean bfs(ArrayList<ArrayList<Integer>> gr , int N) {
		int order[] = new int[N];
		for(int i = 0 ; i < N ; i++) {
			for(int j : gr.get(i)) {
				order[j]++ ;
			}
		}
		
		Queue<Integer> q = new LinkedList<>() ;
		for(int i = 0 ; i < N ; i++) {
			if(order[i]==0) {
				q.add(i);
			}
		}
		int idx = 0 ;
		while(!q.isEmpty()) {
			int el = q.poll();
			idx++ ;	
			for(int it: gr.get(el)) {
				order[it]--;
				if(order[it] == 0) {
					q.add(it);
				}
			}
		}
		if(idx==N) return false ;
		else return true; 
	}
	

}
