package trie;

import java.util.*;

public class HuffmanEncode {
	HashMap<Character, String> encoder;
	HashMap<String, Character> decoder;

	public HuffmanEncode(String feeder) {
		// 1. Create frequency MaP of THIS FEEDER STRIING
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			char cc = feeder.charAt(i);
			if (fmap.containsKey(cc)) {
				fmap.put(cc, fmap.get(cc) + 1);
			} else {
				fmap.put(cc, 1);
			}

		}

		// 2. Create a minheap of Trees
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		Set<Map.Entry<Character, Integer>> entryset = fmap.entrySet();
		for (Map.Entry<Character, Integer> entry : entryset) {
			Node node = new Node(entry.getKey(), entry.getValue());
			minHeap.add(node);
		}

		// 3. Combine nodes until one Node is left in heap
		while (minHeap.size() != 1) {
			Node minone = minHeap.remove();
			Node mintwo = minHeap.remove();

			Node combined = new Node(minone, mintwo);
			combined.cost = minone.cost + mintwo.cost;
			minHeap.add(combined);
		}
		Node ft = minHeap.remove();
		this.encoder = new HashMap<>();
		this.decoder = new HashMap<>();

		this.initEncoderDecoder(ft, "");
	}

	// filling encode and decode
	private void initEncoderDecoder(Node ft, String osf) {
		if (ft == null) {
			return;
		}
		if (ft.left == null && ft.right == null) {
			this.encoder.put(ft.data, osf);
			this.decoder.put(osf, ft.data);
		}
		this.initEncoderDecoder(ft.left, osf + "0");
		this.initEncoderDecoder(ft.right, osf + "1");
	}

	public String encode(String source){
		String rv = "";
	   for(int i = 0 ; i  < source.length() ; i++) {
		   String code = this.encoder.get(source.charAt(i));
		   rv = rv+code;
	   }
	   return rv ;
	} 
	
	public String decode(String codeString ) {
		String rv = "";
		String key = "";
	   for(int i = 0 ; i  < codeString.length() ; i++) {
		   key = key + codeString.charAt(i);
		   if(this.decoder.containsKey(key)) {
			   rv = rv + this.decoder.get(key);
			   key = "";
		   }
	   }
	   return rv ;
	} 
	
	private class Node implements Comparator<Node> {

		Character data;
		int cost;
		Node left;
		Node right;

		Node(char data, int cost) {
			this.data = data;
			this.cost = cost;
			this.left = null;
			this.right = null;
		}

		Node(Node left, Node right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.cost - o2.cost;
		}

	}
}
