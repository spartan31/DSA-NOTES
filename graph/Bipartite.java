package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Bipartite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Integer>>  gr  = new ArrayList<ArrayList<Integer>>() ;
	   	int V = 7 ;
	   	for(int i = 0 ; i < V ; i++) {
	   		gr.add(new ArrayList<Integer>());
	   	}
	   	
	   	gr.get(0).add(1);
	   	gr.get(1).add(0);
	   	
	   	gr.get(1).add(2);
	   	gr.get(2).add(1);
	   	
	   	gr.get(2).add(3);
	   	gr.get(3).add(2);
	   	
	   	gr.get(4).add(3);
	   	gr.get(3).add(4);
	   	
	   	gr.get(4).add(5);
	   	gr.get(5).add(4);
	   	
	   	gr.get(4).add(6);
	   	gr.get(6).add(4) ;
	   	
	   	gr.get(1).add(6);
	   	gr.get(6).add(1) ;
	   	
       if(bipartite(gr,V)) System.out.println(true); 
       else System.out.println(false);
	}

	private static boolean bipartite(ArrayList<ArrayList<Integer>> gr , int V) {
		int color[] = new int[V+1] ;
		Arrays.fill(color, -1);
		for(int i = 0  ; i  <  V  ; i++) {
			if(color[i] == -1 ) {
				if(!bfs(i,color, gr)) return false ;
			}
		}	
		return true;
	}

	private static boolean bfs(int i, int[] color, ArrayList<ArrayList<Integer>> gr) {
		Queue<Integer> q = new LinkedList<>() ;
		q.add(i) ;
		color[i] = 1 ;
		while(!q.isEmpty()){
			int  n = q.poll();
			for(int j : gr.get(n)) {
				if(color[j] == -1) {
					q.add(j);
					color[j] = 1 - color[n];
				}else if(color[j] == color[n]){ return false ;}
			}
		}
		return true;
	}
	
	private static boolean dfs(int i, int[] color, ArrayList<ArrayList<Integer>> gr) {
		if(color[i] == -1) color[i] = 1 ;
		
		for(int j : gr.get(i)) {
			if(color[j] == -1) {
				color[j] = 1 ;
				if(!dfs(j,color,gr)) return false ;
			}else if(color[i] == color[j]) {
				return false ;
			}
		}
		
		return true; 
	}

}
