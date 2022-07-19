package graph;

import java.util.ArrayList;
import java.util.HashMap;

import hasmapimplement.LinkedList;
import java.util.*;

public class Graph {

	class vertex {
		HashMap<String, Integer> nbr = new HashMap<>();
	}

	HashMap<String, vertex> vtces;

	Graph() {
		vtces = new HashMap<>();
	}

	public int numVertex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String a) {
		return this.vtces.containsKey(a);
	}

	public void addVertex(String a) {
		vertex v = new vertex();
		this.vtces.put(a, v);
	}

	public void removeVertex(String a) {
		vertex vtx = vtces.get(a);
		ArrayList<String> keys = new ArrayList<>(vtx.nbr.keySet());
		for (String key : keys) {
			vertex v = vtces.get(key);
			v.nbr.remove(a);
		}

		vtces.remove(a);
	}

	public int numEdges() {
		int count = 0;
		ArrayList<String> key = new ArrayList<>(vtces.keySet());
		for (String s : key) {
			vertex vtx = vtces.get(s);
			count += vtx.nbr.size();
		}

		return count / 2;
	}

	public boolean containEdge(String a, String b) {
		vertex v1 = vtces.get(a);
		vertex v2 = vtces.get(b);

		if (v1 == null || v2 == null || !v1.nbr.containsKey(b)) {
			return false;
		}

		return true;
	}

	public void addEdge(String a, String b, int cost) {
		vertex v1 = vtces.get(a);
		vertex v2 = vtces.get(b);

		if (v1 == null || v2 == null || v1.nbr.containsKey(b)) {
			return;
		}
		v1.nbr.put(b, cost);
		v2.nbr.put(a, cost);
	}

	public void removeEdge(String a, String b) {
		vertex v1 = vtces.get(a);
		vertex v2 = vtces.get(b);

		if (v1 == null || v2 == null || !v1.nbr.containsKey(b)) {
			return;
		}

		v1.nbr.remove(b);
		v2.nbr.remove(a);

	}

	public void display() {
		System.out.println("------------------------------------");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		for (String key : keys) {
			vertex vtx = vtces.get(key);
			System.out.println(key + " : " + vtx.nbr);
		}

		System.out.println("------------------------------------");
	}

	public boolean haspath(String a, String b, HashMap<String, Boolean> proc) {

		proc.put(a, true);
		if (containEdge(a, b)) {
			return true;
		}

		vertex vtx = vtces.get(a);
		ArrayList<String> keys = new ArrayList<>(vtx.nbr.keySet());
		for (String key : keys) {
			if (!proc.containsKey(key) && haspath(key, b, proc)) {
				return true;
			}
		}

		return false;

	}

	public boolean bfs(String src, String dst) throws Exception {
		HashMap<String, Boolean> proc = new HashMap<>();
		LinkedList<Node> q = new LinkedList<>();
		Node vtx = new Node();
		vtx.vname = src;
		vtx.psf = src;

		q.addLast(vtx);
		while (!q.isEmpty()) {
			Node rvtx = q.removeFirst();
			if (proc.containsKey(rvtx.vname)) {
				continue;
			}
			proc.put(rvtx.vname, true);

			if (containEdge(rvtx.vname, dst)) {
				System.out.println(rvtx.psf + dst + " ");
				return true;
			}

			vertex key = vtces.get(rvtx.vname);
			ArrayList<String> nbrs = new ArrayList<>(key.nbr.keySet());
			for (String keys : nbrs) {
				if (!proc.containsKey(keys)) {
					Node nn = new Node();
					nn.vname = keys;
					nn.psf = rvtx.psf + keys;
					q.addLast(nn);
				}
			}
		}
		return false;
	}

	public boolean dfs(String src, String dst) throws Exception {
		HashMap<String, Boolean> proc = new HashMap<>();
		LinkedList<Node> st = new LinkedList<>();
		Node vtx = new Node();
		vtx.vname = src;
		vtx.psf = src;

		st.addfirst(vtx);
		while (!st.isEmpty()) {
			Node rvtx = st.removeFirst();
			if (proc.containsKey(rvtx.vname)) {
				continue;
			}
			proc.put(rvtx.vname, true);

			if (containEdge(rvtx.vname, dst)) {
				System.out.println(rvtx.psf + dst + " ");
				return true;
			}

			vertex key = vtces.get(rvtx.vname);
			ArrayList<String> nbrs = new ArrayList<>(key.nbr.keySet());
			for (String keys : nbrs) {
				if (!proc.containsKey(keys)) {
					Node nn = new Node();
					nn.vname = keys;
					nn.psf = rvtx.psf + keys;
					st.addfirst(nn);
				}
			}
		}
		return false;
	}

	public void bft() throws Exception {
		HashMap<String, Boolean> proc = new HashMap<>();
		LinkedList<Node> q = new LinkedList<>();

		ArrayList<String> tra = new ArrayList<>(vtces.keySet());

		for (String rt : tra) {

			if (proc.containsKey(rt)) {
				continue;
			}
			Node vtx = new Node();
			vtx.vname = rt;
			vtx.psf = rt;

			q.addLast(vtx);
			while (!q.isEmpty()) {
				Node rvtx = q.removeFirst();
				if (proc.containsKey(rvtx.vname)) {
					continue;
				}
				proc.put(rvtx.vname, true);

				System.out.println(rvtx.vname + "  via  " + rvtx.psf );

				vertex key = vtces.get(rvtx.vname);
				ArrayList<String> nbrs = new ArrayList<>(key.nbr.keySet());
				for (String keys : nbrs) {
					if (!proc.containsKey(keys)) {
						Node nn = new Node();
						nn.vname = keys;
						nn.psf = rvtx.psf + keys;
						q.addLast(nn);
					}
				}
			}
		}
	}
	
	public void dft() throws Exception {
		HashMap<String, Boolean> proc = new HashMap<>();
		LinkedList<Node> stack = new LinkedList<>();

		ArrayList<String> tra = new ArrayList<>(vtces.keySet());

		for (String rt : tra) {

			if (proc.containsKey(rt)) {
				continue;
			}
			Node vtx = new Node();
			vtx.vname = rt;
			vtx.psf = rt;

			stack.addfirst(vtx);
			while (!stack.isEmpty()) {
				Node rvtx = stack.removeFirst();
				if (proc.containsKey(rvtx.vname)) {
					continue;
				}
				proc.put(rvtx.vname, true);

				System.out.println(rvtx.vname + "  via  " + rvtx.psf );

				vertex key = vtces.get(rvtx.vname);
				ArrayList<String> nbrs = new ArrayList<>(key.nbr.keySet());
				for (String keys : nbrs) {
					if (!proc.containsKey(keys)) {
						Node nn = new Node();
						nn.vname = keys;
						nn.psf = rvtx.psf + keys;
						stack.addfirst(nn);
					}
				}
			}
		}
	}


}

class Node {
	String vname;
	String psf;
}