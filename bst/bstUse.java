 package bst;

import java.util.*;

import bst.Pair;

public class bstUse {
	public static ArrayList<Integer> getpath(Bst<Integer> root , int e){
		if(root == null) {
			return null;
		}
		
		if(root.data == e) {
			ArrayList<Integer> out = new ArrayList<>();
			out.add(root.data);
			return out;
		}
		ArrayList<Integer> leftout = getpath(root.left , e);
		if(leftout != null) {
			leftout.add(root.data);
			return leftout;
		}
		
		ArrayList<Integer> rightout = getpath(root.right , e);
		if(rightout != null) {
			rightout.add(root.data);
			return rightout;
		}
		else {
			return null;
		}
		
	}
	
	public static Bst<Integer> bstfromarray(int arr[] , int s , int e){
		if(s>e) {
			return null ;
		}
		int mid = s + (e - s)/2 ;
		Bst<Integer> ans = new Bst<>(arr[mid]);
		ans.left = bstfromarray(arr , s , mid-1);
		ans.right = bstfromarray(arr,mid+1,e);
		return ans;
		
	}
	
	public static Boolean bst3(Bst<Integer> root, int min , int max) {
		if(root == null) {
			return true;
		}
		if(root.data  < min || root.data > max) {
			return false;
		}
		
		boolean left = bst3(root.left,min,root.data-1);
		boolean right = bst3(root.right,root.data ,max);
		return left && right ;
	}
	
	
	/* here height is used for first character and daimeter is used for second character  First is min and second is max */
	
	public static Pair< Boolean , Pair<Integer, Integer>> bst2(Bst<Integer> root){
	if(root == null) {
		Pair< Boolean , Pair<Integer, Integer>> output = new Pair<Boolean , Pair<Integer, Integer>>();
		output.height = true;
		output.diameter = new Pair<Integer , Integer>();
		output.diameter.height = Integer.MAX_VALUE;
		output.diameter.diameter = Integer.MIN_VALUE;
		return output;
	}
	Pair< Boolean , Pair<Integer, Integer>> leftout = bst2(root.left);
	Pair< Boolean , Pair<Integer, Integer>> rightout = bst2(root.right);
	int min = Math.min(root.data, Math.min(leftout.diameter.height, rightout.diameter.height));
	int max = Math.max(root.data , Math.max(leftout.diameter.diameter, rightout.diameter.diameter));
	
	boolean isBst  = (root.data > leftout.diameter.diameter)
			      && (root.data <= rightout.diameter.height)
			      && leftout.height && rightout.height;
	
	Pair<Boolean,  Pair<Integer,Integer>> output = new Pair<>();
	output.height = isBst;
	output.diameter = new Pair<Integer , Integer>();
	output.diameter.height = min;
	output.diameter.diameter = max;
	return output;
	}

	public static int maximum(Bst<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	}

	public static int minimum(Bst<Integer> root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}

	public static boolean isBst(Bst<Integer> root) {
		if (root == null) {
			return true;
		}
		int max = maximum(root.left);
		int min = minimum(root.right);
		if (root.data < max) {
			return false;
		}
		if (root.data > min) {
			return false;
		}

		boolean left = isBst(root.left);
		boolean right = isBst(root.right);

		if (left && right) {
			return true;
		} else {
			return false;
		}
	}

	public static void range(Bst<Integer> root, int a, int b) {
		if (root == null) {
			return;
		}
		if (root.data > a && root.data < b) {
			System.out.print(root.data + " ");
		}
		if (root.data > a) {
			range(root.left, a, b);
		}
		if (root.data < b) {
			range(root.right, a, b);
		}

	}

	public static void inorder(Bst<Integer> root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);

	}

	public static void preorder(Bst<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void postorder(Bst<Integer> root) {
		if (root == null) {
			return;
		}

		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}

	public static Pair<Integer, Integer> heightdiameter(Bst<Integer> root) {
		if (root == null) {
			Pair<Integer, Integer> out = new Pair<>();
			out.height = 0;
			out.diameter = 0;
			return out;
		}
		Pair<Integer, Integer> lo = heightdiameter(root.left);
		Pair<Integer, Integer> ro = heightdiameter(root.right);
		int height = 1 + Math.max(lo.height, ro.height);
		int option1 = lo.height + ro.height;
		int option2 = lo.diameter;
		int option3 = ro.diameter;
		int diameter = Math.max(option1, Math.max(option2, option3));
		Pair<Integer, Integer> out = new Pair<>();
		out.height = height;
		out.diameter = diameter;
		return out;
	}

	public static int diameter(Bst<Integer> root) {
		if (root == null) {
			return 0;
		}

		int option1 = height(root.left) + height(root.right);
		int optoin2 = diameter(root.left);
		int option3 = diameter(root.right);

		return Math.max(option1, Math.max(optoin2, option3));
	}

	private static int height(Bst<Integer> root) {
		if (root == null)
			return 0;
		int lh = height(root.left);
		int rh = height(root.right);

		return 1 + Math.max(lh, rh);
	}

	public static int countnode(Bst<Integer> root) {
		if (root == null)
			return 0;
		int count = 1;
		count += countnode(root.left);
		count += countnode(root.right);
		return count;
	}

	public static void printtree(Bst<Integer> root) {
		if (root == null) {
			return;
		}
		String ss = root.data + " :";
		if (root.left != null) {
			ss += " L " + root.left.data;
		}
		if (root.right != null) {
			ss += " R " + root.right.data;
		}

		System.out.println(ss);
		printtree(root.left);
		printtree(root.right);

	}

	public static Bst<Integer> takeinput(Scanner sc) {
		System.out.println("Enter root data");
		int data = sc.nextInt();
		if (data == -1) {
			return null;
		}
		Bst<Integer> root = new Bst<>(data);
		root.left = takeinput(sc);
		root.right = takeinput(sc);

		return root;
	}

	public static Bst<Integer> takeinputlevel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data");
		Queue<Bst<Integer>> pendingnodes = new LinkedList<>();
		int rootdata = sc.nextInt();
		if (rootdata == -1) {
			return null;
		}
		Bst<Integer> root = new Bst<>(rootdata);
		pendingnodes.add(root);
		while (!pendingnodes.isEmpty()) {
			Bst<Integer> front = pendingnodes.remove();
			System.out.println("Enter left child of " + front.data);
			int leftchild = sc.nextInt();
			if (leftchild != -1) {
				Bst<Integer> child = new Bst<>(leftchild);
				pendingnodes.add(child);
				front.left = child;
			}
			System.out.println("Enter right child of" + front.data);
			int right = sc.nextInt();
			if (right != -1) {
				Bst<Integer> childr = new Bst<Integer>(right);
				pendingnodes.add(childr);
				front.right = childr;
			}
		}
		return root;
	}

	public static void printlevel(Bst<Integer> root) {
		Queue<Bst<Integer>> start = new LinkedList<>();
		start.add(root);
		while (!start.isEmpty()) {
			Bst<Integer> temp = start.remove();
			System.out.print(temp.data + ": ");
			if (temp.left != null) {
				System.out.print(" L " + temp.left.data);
				start.add(temp.left);
			}
			if (temp.right != null) {
				System.out.print(" R " + temp.right.data);
				start.add(temp.right);
			}

			System.out.println();
		}

	}

	public static Bst<Integer> treebuilder(int in[], int pre[]) {
		return buildtreehelp(in, pre, 0, in.length - 1, 0, pre.length - 1);
	}

	private static Bst<Integer> buildtreehelp(int[] in, int[] pre, int inS, int inE, int preS, int preE) {
		if (inS > inE) {
			return null;
		}

		int rootData = pre[preS];
		Bst<Integer> root = new Bst<Integer>(rootData);
		int rootIndex = -1;
		for (int i = inS; i <= inE; i++) {
			if (in[i] == rootData) {
				rootIndex = i;
				break;
			}
		}

		int leftinS = inS;
		int leftinE = rootIndex - 1;
		int leftpreS = preS + 1;
		int leftpreE = leftinE - leftinS + leftpreS;
		int rightinS = rootIndex + 1;
		int rightinE = inE;
		int rightpreS = leftpreE + 1;
		int rightpreE = preE;

		root.left = buildtreehelp(in, pre, leftinS, leftinE, leftpreS, leftpreE);
		root.right = buildtreehelp(in, pre, rightinS, rightinE, rightpreS, rightpreE);

		return root;
	}

	public static Bst<Integer> postin(int in[], int post[]) {
		return postinhelp(in, post, 0, in.length - 1, 0, post.length - 1);
	}

	public static Bst<Integer> postinhelp(int in[], int post[], int inS, int inE, int postS, int postE) {
		if (inS > inE) {
			return null;
		}
		int rootData = post[postE];
		Bst<Integer> root = new Bst<Integer>(rootData);
		int rootIndex = -1;
		for (int i = inS; i <= inE; i++) {
			if (in[i] == rootData) {
				rootIndex = i;
				break;
			}
		}

		int leftinS = inS;
		int leftinE = rootIndex - 1;
		int leftpostS = postS;
		int leftpostE = leftpostS - leftinS + leftinE;
		int rightinS = rootIndex + 1;
		int rightinE = inE;
		int rightpostS = leftpostE + 1;
		int rightpostE = postE - 1;
		root.left = postinhelp(in, post, leftinS, leftinE, leftpostS, leftpostE);
		root.right = postinhelp(in, post, rightinS, rightinE, rightpostS, rightpostE);

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner sc = new Scanner(System.in);
		// Bst<Integer> nn = takeinput(sc);
		// Bst<Integer> nn = takeinputlevel();
		// printtree(nn);
		// printlevel(nn);
//			System.out.println("No of nodes are " + countnode(nn));
//			System.out.println("Diameter of three is : " + diameter(nn));
//			Pair<Integer,Integer> ans = heightdiameter(nn);
//			System.out.println("height :" + ans.height); 
//			System.out.println("diameter : " + ans.diameter);
//			System.out.println();
//			inorder(nn);
//			System.out.println();
//			preorder(nn);
//			System.out.println();
//			postorder(nn);
//			int in[] = {4, 2, 5, 1, 3, 7};
//			int pre[] = {1, 2, 4, 5, 3, 7};
//			Bst<Integer> root = treebuilder(in,pre);
//			printlevel(root);
//        Bst<Integer> root = takeinputlevel();
	//	printlevel(root);
		//System.out.println(isBst(root));
	//     Pair<Boolean , Pair<Integer , Integer>> result = bst2(root);
	 //    System.out.println(result.height);
		int arr[] = {1 ,2, 3, 4, 5, 6, 7, 8};
		Bst<Integer> nn = bstfromarray(arr,0,arr.length-1);
	//	printlevel(nn);
	//	System.out.println(isBst(nn));
	 //   System.out.println(getpath(nn,3));
	    bstClass hi = new bstClass();
	    hi.insert(10);
	    hi.insert(20);
	    hi.insert(11);
	    hi.insert(15);
	    hi.print();
	    hi.delete(10);
	    hi.print();
	    System.out.println(hi.search(10));
	    printtree(nn);
	}

}
