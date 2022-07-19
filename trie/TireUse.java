package trie;

public class TireUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		Trie t = new Trie();
		t.add("hello");
		t.add("hii");
		System.out.println(t.search("hii"));
		t.add("hit");
		t.remove("hii");
		System.out.println(t.search("hii"));
	}

}
