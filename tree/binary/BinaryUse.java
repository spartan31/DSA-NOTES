package tree.binary;

import java.util.*;


import trees.treeNode;

public class BinaryUse {
	
     public static void inorder(treeBinary<Integer> root) {
		if(root == null) {
			return ;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
		
	}
	
	public static void preorder(treeBinary<Integer> root) {
		if(root == null) {
			return ;
		}
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void postorder(treeBinary<Integer> root) {
		if(root == null ) {
			return ;
		}
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static Pair<Integer,Integer> heightdiameter(treeBinary<Integer> root){
	if(root == null) {
		Pair<Integer,Integer> out = new Pair<>();
		out.height = 0;
		out.diameter = 0;
		return out ;
	       }
		Pair<Integer,Integer> lo = heightdiameter(root.left);
		Pair<Integer,Integer> ro = heightdiameter(root.right);
		int height = 1+ Math.max(lo.height, ro.height);
		int option1 = lo.height + ro.height ;
		int option2 = lo.diameter;
		int option3 = ro.diameter;
		int diameter = Math.max(option1, Math.max(option2, option3));
		Pair<Integer,Integer> out = new Pair<>();
		out.height = height;
		out.diameter = diameter;
		return out;
	}
	
	public static int diameter(treeBinary<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		int option1 = height(root.left) + height(root.right);
		int optoin2 = diameter(root.left); 
		int option3 = diameter(root.right);
		
		return Math.max(option1, Math.max(optoin2, option3));
	}
	
	
	private static int height(treeBinary<Integer> root) {
      if(root == null)
		return 0;
      int lh=  height(root.left);
      int rh = height(root.right);
      
      return 1+ Math.max(lh, rh) ;
	}


	public static int countnode(treeBinary<Integer> root) {
		if(root == null)
		return 0;
		int count = 1;
		count += countnode(root.left);
		count += countnode(root.right);
		return count;
}
	public static void printtree(treeBinary<Integer> root) {
		if(root == null) {
			return ;
		}
		String ss = root.data + " :" ;
		if(root.left != null) {
			ss += " L " + root.left.data ;
		}
		if(root.right != null) {
			ss += " R " + root.right.data;
		}
		
		System.out.println(ss);
		printtree(root.left);
		printtree(root.right);
		
	}
	public static treeBinary<Integer> takeinput(Scanner sc) {
		System.out.println("Enter root data");
		int data = sc.nextInt();
       if(data == -1) {
			return null;
		}
		treeBinary<Integer> root = new treeBinary<>(data);
		root.left = takeinput(sc);
		root.right = takeinput(sc);
		
		return root;
	}
	
	public static treeBinary<Integer> takeinputlevel(){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter root data");
		Queue<treeBinary<Integer>> pendingnodes = new LinkedList<>();
		int rootdata = sc.nextInt();
		if(rootdata == -1) {
			return null;
		}
		treeBinary<Integer> root = new treeBinary<>(rootdata);
		pendingnodes.add(root);
		while(!pendingnodes.isEmpty()) {
			treeBinary<Integer>   front = pendingnodes.remove();
			System.out.println("Enter left child of " + front.data);
			int leftchild = sc.nextInt();
			if(leftchild != -1) {
				treeBinary<Integer> child = new treeBinary<>(leftchild);
				pendingnodes.add(child);
				front.left = child;
			}
		     System.out.println("Enter right child of"  + front.data);
		     int right = sc.nextInt();
		     if(right != -1) {
		    	 treeBinary<Integer> childr = new treeBinary<Integer>(right);
		         pendingnodes.add(childr);
		         front.right = childr;
		     }
 		}
		return root;
	}
	
	public static void printlevel(treeBinary<Integer> root) {
		Queue<treeBinary<Integer>> start = new LinkedList<>();
		start.add(root);
		while(!start.isEmpty()) {
			treeBinary<Integer> temp = start.remove();
			System.out.print(temp.data + ": ");
			if(temp.left != null) {
				System.out.print(" L " + temp.left.data);
				start.add(temp.left);
			}
			if(temp.right !=null) {
				System.out.print(" R " + temp.right.data);
				start.add(temp.right);
			}
			
			System.out.println();
		}
		
	}
     
	public static treeBinary<Integer> treebuilder(int in[] , int pre[] ){
		return buildtreehelp(in,pre,0,in.length-1,0,pre.length-1);
	}
	
	private static treeBinary<Integer> buildtreehelp(int[] in, int[] pre, int inS, int inE, int preS, int preE) {
		if(inS > inE) {
		return null;
		}
		
		int rootData =  pre[preS];
		treeBinary<Integer> root = new treeBinary<Integer>(rootData);
		int rootIndex = -1;
		for(int i = inS; i <= inE;i++) {
			if(in[i] == rootData) {
				rootIndex = i;
				break;
			}
		}
		
		int leftinS = inS;
		int leftinE = rootIndex -1;
		int leftpreS = preS+1;
		int leftpreE = leftinE - leftinS + leftpreS ;
		int rightinS = rootIndex+1;
		int rightinE = inE;
		int rightpreS = leftpreE+1;
		int rightpreE = preE;
		
		root.left = buildtreehelp(in,pre,leftinS,leftinE,leftpreS,leftpreE);
		root.right = buildtreehelp(in,pre,rightinS,rightinE,rightpreS,rightpreE);
		
		return root;
	}

	public static treeBinary<Integer> postin(int in[], int post[]){
		return postinhelp(in , post,0,in.length-1,0,post.length-1);
	}
	
	public static treeBinary<Integer> postinhelp(int in[], int post[], int  inS,int inE, int postS, int postE){
		if(inS > inE) {
			return null;
		}
		int rootData = post[postE];
		treeBinary<Integer> root = new treeBinary<Integer>(rootData);
		int rootIndex = -1;
		for(int i = inS; i <= inE ; i++) {
			if(in[i] == rootData) {
				rootIndex = i;
				break;
			}
		}
		
		int leftinS  = inS;
		int leftinE  = rootIndex - 1;
		int leftpostS  = postS;
		int leftpostE  = leftpostS - leftinS + leftinE;
		int rightinS  = rootIndex + 1 ;
		int rightinE  = inE;
		int rightpostS  = leftpostE+1;
		int rightpostE = postE-1;		
		root.left = postinhelp(in,post,leftinS,leftinE,leftpostS,leftpostE);
		root.right = postinhelp(in,post,rightinS,rightinE,rightpostS,rightpostE);
		
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Scanner sc = new Scanner(System.in);
	//	treeBinary<Integer> nn = takeinput(sc);
	//	treeBinary<Integer> nn = takeinputlevel();
	//	printtree(nn);
	//	printlevel(nn);
//		System.out.println("No of nodes are " + countnode(nn));
//		System.out.println("Diameter of three is : " + diameter(nn));
//		Pair<Integer,Integer> ans = heightdiameter(nn);
//		System.out.println("height :" + ans.height);
//		System.out.println("diameter : " + ans.diameter);
//		System.out.println();
//		inorder(nn);
//		System.out.println();
//		preorder(nn);
//		System.out.println();
//		postorder(nn);
//		int in[] = {4, 2, 5, 1, 3, 7};
//		int pre[] = {1, 2, 4, 5, 3, 7};
//		treeBinary<Integer> root = treebuilder(in,pre);
//		printlevel(root);
      
		int in[] = {4, 8, 2, 5, 1, 6, 3, 7};
		int post[] = {8, 4, 5, 2, 6, 7, 3, 1 };
		treeBinary<Integer> root = postin(in,post);
		printlevel(root);
	}

}
// 1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1
