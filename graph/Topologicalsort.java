package graph;

import java.util.*;

public class Topologicalsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] sort(ArrayList<ArrayList<Integer>> gr , int V) {
		int vis[] = new int[V];
		Stack<Integer> st = new Stack<Integer>() ;
		for(int i = 0 ; i <V ; i++ ) {
			if(vis[i] == 0) {
				dfs(i,st,gr,vis);
			}
		}		
		int ans[] = new int[V];
		
		for(int i = 0 ; i < V ; i++) {
			ans[i] = st.pop();
		}
		
		return ans ;
	}

	private static void dfs(int i, Stack<Integer> st, ArrayList<ArrayList<Integer>> gr, int[] vis) {
		// TODO Auto-generated method stub
		vis[i] = 1 ;
		for(int j : gr.get(i)) {
			if(vis[j] == 0) {
				dfs(j,st,gr,vis);
			}
		}
		st.push(i);
	}

}
