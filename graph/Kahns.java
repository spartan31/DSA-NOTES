package graph;

import java.util.*;

public class Kahns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] topo(ArrayList<ArrayList<Integer>> gr , int N) {
		int ans[] = new int[N];
		int order[] = new int[N];
		for(int i = 0 ; i < N; i++) {
			for(int it : gr.get(i)) {
				order[it]++ ;
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
			ans[idx++] = el ;
			
			for(int it: gr.get(el)) {
				order[it]--;
				if(order[it] == 0) {
					q.add(it);
				}
			}
		}
		
		return ans ;
	}

}
