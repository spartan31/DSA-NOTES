package trie;

public class HuffUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String str = "aabsjsaaas";
       HuffmanEncode hf = new HuffmanEncode(str);
       String code = hf.encode(str);
       System.out.println(code);
       String oe = hf.decode(code);
       System.out.println(oe);
	}

}
