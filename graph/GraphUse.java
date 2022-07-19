package graph;

public class GraphUse {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Graph graph = new Graph() ;
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
        
		
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 3);
		graph.addEdge("B", "C", 1);
		graph.addEdge("C", "D", 8);
		graph.addEdge("D", "E", 10);
		graph.addEdge("E", "F", 45);
		graph.addEdge("E", "G", 7);
		graph.addEdge("F", "G", 18);
		graph.display();
		
		System.out.println(graph.containEdge("A", "B"));
//		System.out.println(graph.numEdges());
//		System.out.println(graph.numVertex());
//		
//		System.out.println(graph.containEdge("A", "C"));
//		
    	graph.removeEdge("D", "E");
//		graph.display();
//		
//		graph.removeVertex("F");
//		graph.display();
//		
//		graph.addVertex("K");
//		graph.addEdge("K", "A", 20);
//		
//		graph.display();
		
		
	//	System.out.println(graph.dfs("A", "K"));
	  graph.bft();
	  System.out.println("------------------------------");
	  graph.dft();
	
	}

}
